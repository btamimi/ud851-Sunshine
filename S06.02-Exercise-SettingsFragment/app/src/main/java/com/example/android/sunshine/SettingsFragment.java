package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.preference.PreferenceScreen;

/**
 * Created by basel.tamimi on 2/8/2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Preference preference = findPreference(s);
        if(preference != null) {
            if (!(preference instanceof CheckBoxPreference)) {
                String key = preference.getKey();
                String value = sharedPreferences.getString(key, "");

                setPreferenceSummary(preference, value);
            }
        }
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_weather);

        SharedPreferences sharedPreferences= getPreferenceScreen().getSharedPreferences();
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        for (int i = 0; i < preferenceScreen.getPreferenceCount(); i++) {
             Preference p = preferenceScreen.getPreference(i);
            if (!(p instanceof CheckBoxPreference)){
                String key = p.getKey();
                String value = sharedPreferences.getString(key,"");

                setPreferenceSummary(p,value);
            }
        }
    }

    private void setPreferenceSummary(Preference preference, Object value){

        //String key = preference.getKey();
        String stringValue = value.toString();

        if(preference instanceof ListPreference){
            int index = ((ListPreference) preference).findIndexOfValue(stringValue);
            if(index >= 0) {
                String summary = (String) ((ListPreference) preference).getEntries()[index];
                preference.setSummary(summary);
            }
        }
        else if (preference instanceof EditTextPreference){
         preference.setSummary(stringValue);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences preferenceManager = PreferenceManager.getDefaultSharedPreferences(getContext());
        preferenceManager.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences preferenceManager = PreferenceManager.getDefaultSharedPreferences(getContext());
        preferenceManager.unregisterOnSharedPreferenceChangeListener(this);
    }
}
