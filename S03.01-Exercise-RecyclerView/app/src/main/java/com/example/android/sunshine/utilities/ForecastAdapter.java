package com.example.android.sunshine.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

/**
 * Created by basel.tamimi on 2/1/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {



    // Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
    // COMPLETED (15) Add a class file called ForecastAdapter
    // COMPLETED (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

    // COMPLETED (23) Create a private string array called mWeatherData
    private String[] mWeatherData;
    // COMPLETED (47) Create the default constructor (we will pass in parameters in a later lesson)

    public ForecastAdapter() {
    }

    // COMPLETED (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // COMPLETED (17) Extend RecyclerView.ViewHolder

    // COMPLETED (24) Override onCreateViewHolder
    // COMPLETED (25) Within onCreateViewHolder, inflate the list item xml into a view
    // COMPLETED (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter





    // COMPLETED (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // COMPLETED (32) After you save mWeatherData, call notifyDataSetChanged

    public void setmWeatherData(String[] mWeatherData) {
        this.mWeatherData = mWeatherData;
        notifyDataSetChanged();
    }


    // Within ForecastAdapter.java /////////////////////////////////////////////////////////////////

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        int LayoutIDForInflater = R.layout.forecast_list_item;
        boolean shouldAttachedToParentImmediately = false;

        View view = inflater.inflate(LayoutIDForInflater,parent,shouldAttachedToParentImmediately);
        ForecastAdapterViewHolder ViewHolder = new ForecastAdapterViewHolder(view);

        return ViewHolder;
    }

    // COMPLETED (27) Override onBindViewHolder
    // TODO (28) Set the text of the TextView to the weather for this list item's position
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    // COMPLETED (29) Override getItemCount
    // COMPLETED (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
    @Override
    public int getItemCount() {
        if(mWeatherData == null) {
            return 0;
        }
        return mWeatherData.length;
    }



    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
        // COMPLETED (18) Create a public final TextView variable called mWeatherTextView

        // COMPLETED (19) Create a constructor for this class that accepts a View as a parameter
        // COMPLETED (20) Call super(view) within the constructor for ForecastAdapterViewHolder
        // COMPLETED (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView

        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////

        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            this.mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }
}
