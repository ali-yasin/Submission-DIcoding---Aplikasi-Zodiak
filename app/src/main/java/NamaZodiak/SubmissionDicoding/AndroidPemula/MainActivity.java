package NamaZodiak.SubmissionDicoding.AndroidPemula;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvZodiak;
    private ArrayList<Zodiak> listZodiak = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvZodiak = findViewById(R.id.list);
        rvZodiak.setHasFixedSize(true);
        listZodiak.addAll(DataZodiak.getData());

        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_me:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList() {
        rvZodiak.setLayoutManager(new LinearLayoutManager(this));
        ZodiakListAdapter ZodiakListAdapter = new ZodiakListAdapter(listZodiak);
        rvZodiak.setAdapter(ZodiakListAdapter);
        ZodiakListAdapter.setOnItemClickCallback(new ZodiakListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Zodiak data) {
                moveToDetail(data);
            }
        });

    }

    private void moveToDetail(Zodiak data) {
        Intent intent = new Intent(MainActivity.this, ZodiakDetailActivity.class);
        intent.putExtra(ZodiakDetailActivity.EXTRA_NAME, data.getName());
        intent.putExtra(ZodiakDetailActivity.EXTRA_ORIGIN, data.getOrigin());
        intent.putExtra(ZodiakDetailActivity.EXTRA_DESC, data.getDescription());
        intent.putExtra(ZodiakDetailActivity.EXTRA_IMG, data.getPhoto());
        startActivity(intent);
    }
}
