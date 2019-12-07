package NamaZodiak.SubmissionDicoding.AndroidPemula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ZodiakDetailActivity extends AppCompatActivity {

    public static String EXTRA_NAME = "nama_zodiak";
    public static String EXTRA_ORIGIN = "zodiak_origin";
    public static String EXTRA_DESC = "zodiak_desc";
    public static String EXTRA_IMG = "zodiak_photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiak_detail);

        ImageView zodiakImg = findViewById(R.id.iv_zodiak);
        TextView zodiakName = findViewById(R.id.tv_zodiak_name);
        TextView zodiakOrigin = findViewById(R.id.tv_zodiak_origin);
        TextView zodiakDesc = findViewById(R.id.tv_zodiak_desc);

        Glide.with(this).load(getIntent().getStringExtra(EXTRA_IMG)).into(zodiakImg);
        zodiakName.setText(getIntent().getStringExtra(EXTRA_NAME));
        zodiakDesc.setText(getIntent().getStringExtra(EXTRA_DESC));
        zodiakOrigin.setText(getIntent().getStringExtra(EXTRA_ORIGIN));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Detail " + getIntent().getStringExtra(EXTRA_NAME));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}