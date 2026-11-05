package com.example.comp2000;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

import androidx.fragment.app.DialogFragment;

public class BookingConfirmedDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(Html.fromHtml("<font color='#EFBF04'>Booking has been confirmed</font>"));
        builder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

            }
        });
        return builder.create();

    }
}

