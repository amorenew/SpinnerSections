package com.test.food;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DrinkModel> drinkModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatSpinner spinner = findViewById(R.id.spinner2);
        drinkModels = new ArrayList<>();

        drinkModels.add(new DrinkModel(true, 0, "Cold Drinks", "description", 1.3));
        drinkModels.add(new DrinkModel(false, R.drawable.coke, "Coke", "description", 1.3));
        drinkModels.add(new DrinkModel(false, R.drawable.sprite, "Sprite", "description", 1.3));
        drinkModels.add(new DrinkModel(false, R.drawable.pepsi, "Pepsi", "description", 1.3));
        drinkModels.add(new DrinkModel(true, 0, "Fruits Juice", "description", 1.3));
        drinkModels.add(new DrinkModel(false, R.drawable.orange, "Orange Juice", "description", 1.3));
        drinkModels.add(new DrinkModel(false, R.drawable.straw, "Strawberry Juice", "description", 1.3));
        drinkModels.add(new DrinkModel(false, R.drawable.lemon, "Lemon Juice", "description", 1.3));


        ArrayAdapter<DrinkModel> spinnerAdapter = new ArrayAdapter<DrinkModel>(this, android.R.layout.simple_spinner_dropdown_item, drinkModels) {

            @Override
            public boolean isEnabled(int position) {
                return !drinkModels.get(position).isHeader();
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    Context mContext = this.getContext();
                    LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.row2, null);
                }

                TextView tvName = v.findViewById(R.id.tvName);
                ImageView ivDrink = v.findViewById(R.id.ivDrink);
                DrinkModel model = drinkModels.get(position);
                tvName.setText(model.getName());
                ivDrink.setImageDrawable(ResourcesCompat.getDrawable(getResources(), model.getDrawable(), null));
                return v;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    Context mContext = this.getContext();
                    LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.row, null);
                }

                TextView tvName = v.findViewById(R.id.tvName);
                TextView tvDescription = v.findViewById(R.id.tvDescription);
                TextView tvPrice = v.findViewById(R.id.tvPrice);
                ImageView ivDrink = v.findViewById(R.id.ivDrink);
                DrinkModel model = drinkModels.get(position);
                tvName.setText(model.getName());
                tvDescription.setText(model.getDescription());
                tvPrice.setText(model.getPrice() + " €");
                if (model.getDrawable() > 0)
                    ivDrink.setImageDrawable(ResourcesCompat.getDrawable(getResources(), model.getDrawable(), null));
                if (model.isHeader()) {
                    tvDescription.setVisibility(View.GONE);
                    tvPrice.setVisibility(View.GONE);
                    ivDrink.setVisibility(View.GONE);
                } else {
                    tvDescription.setVisibility(View.VISIBLE);
                    tvPrice.setVisibility(View.VISIBLE);
                    ivDrink.setVisibility(View.VISIBLE);
                }
                return v;
            }
        };

        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(1);//Header should not be selected
    }


}
