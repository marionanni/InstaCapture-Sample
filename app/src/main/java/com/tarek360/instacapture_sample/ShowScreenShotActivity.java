package com.tarek360.instacapture_sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.io.File;

public class ShowScreenShotActivity extends AppCompatActivity {

  private final static String KEY_FILE_PATH = "file_path";
  @BindView(R.id.imageView) ImageView imageView;

  public static Intent buildIntent(Context context, String filePath) {
    Intent intent = new Intent(context, ShowScreenShotActivity.class);
    intent.putExtra(KEY_FILE_PATH, filePath);
    return intent;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show_screen_shot);

    ButterKnife.bind(this);

    String filePath = getIntent().getStringExtra(KEY_FILE_PATH);
    if (filePath != null) {
      Picasso.with(this).load(new File(filePath)).into(imageView);
    }
  }
}
