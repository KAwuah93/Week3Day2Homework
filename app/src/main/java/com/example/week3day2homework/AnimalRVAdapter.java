package com.example.week3day2homework;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalRVAdapter extends RecyclerView.Adapter<AnimalRVAdapter.ViewHolder>{

    public static final String TAG = "TAG_AnimalRVAdapter";
    private ArrayList<Animal> animalArrayList;


    public AnimalRVAdapter(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;
    }
    //You could make a method to populate but maybe cleaner to do it in the viewHolder

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate a view into memory, pul context from the parent and attach it to the parent view
        //set attach to root to false
        View inflatedItem  = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.animal_list_item_proto, parent, false);
                //.inflate(R.layout.animal_list_item, parent, false);
        //Return the view within the Viewholder
        return new ViewHolder(inflatedItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animal currentAnimal = animalArrayList.get(position);
        Log.d(TAG, "onBindViewHolder: curanimal: " + currentAnimal.toString());
        //how you can do it by using a prewritten method
        holder.populateValues(currentAnimal);


    }
    //set this mad lad up
    @Override
    public int getItemCount() {
        return animalArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvAnimalName;
        TextView tvAnimalType;
        TextView tvAnimalAge;
        ImageView ivAnimalImage;

        Animal itemAnimal;

        public ViewHolder(View itemView){
            super(itemView);

            tvAnimalName = itemView.findViewById(R.id.animalName);
            tvAnimalType = itemView.findViewById(R.id.animalType);
            tvAnimalAge = itemView.findViewById(R.id.animalAge);
            ivAnimalImage = itemView.findViewById(R.id.AnimImage);

            //Bind using the the ItemView instead of directly
            //itemText = itemView.findViewById(R.id.animalListItem);
            itemView.setOnClickListener(this);
        }
        public void setItemAnimal(Animal itemAnimal) {
            this.itemAnimal = itemAnimal;
        }

        public void populateValues(Animal animal){
            //Log.d(TAG, animal.getName() + "populateValues: animal: " + animal.toString());
            int animalpic = animal.getImage();
            tvAnimalName.setText(animal.getName() + " the " + animal.getType());
            tvAnimalType.setText(animal.getFans() + " Fans! Know for their " + animal.getTalent());
            tvAnimalAge.setText("is Around: "+animal.getAge() +" years old");
            ivAnimalImage.setImageResource(animal.getImage());

            setItemAnimal(animal);
        }
        @Override
        public void onClick(View view){
//            Intent detailsIntent = new Intent(view.getContext(), DetailsActivity.class);
//            Bundle bundle = new Bundle();
//            bundle.putParcelable("car", itemCar);
//            detailsIntent.putExtras(bundle);
//
//            view.getContext().startActivity(detailsIntent);
        }
    }
}
