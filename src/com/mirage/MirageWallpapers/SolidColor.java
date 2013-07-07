package com.mirage.MirageWallpapers;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;

import java.io.IOException;

public class SolidColor extends Activity {
    
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final CharSequence[] items = getResources().getStringArray(R.array.solid_colors);
        final Context context = this;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(getString(R.string.pick_color));
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                int color = Color.BLACK;
                switch(item){
                    case 0:
                        color = Color.parseColor("#FF4444");
                        break;
                    case 1:
                        color = Color.parseColor("#669900");
                        break;
                    case 2:
                        color = Color.parseColor("#33B5E5");
                        break;
                    case 3:
                        color = Color.parseColor("#AA66CC");
                        break;
                    case 4:
                        color = Color.parseColor("#FF8800");
                        break;
                    case 5:
                        color = Color.WHITE;
                        break;
                    case 6:
                        color = Color.parseColor("#99CC00");;
                        break;
                }
                
                try {
                    WallpaperManager wm = WallpaperManager.getInstance(context);
                    
                    // Create 1x1 bitmap to store the color
                    Bitmap bmp = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);

                    // Make a canvas with which we can draw to the bitmap
                    Canvas canvas = new Canvas(bmp);

                    // Fill with color and save
                    canvas.drawColor(color);
                    canvas.save();

                    wm.setBitmap(bmp);
                    bmp.recycle();
                } catch (IOException e) {
                    // ignore
                }
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.setCancelable(false);
        alert.show();
    }
}
