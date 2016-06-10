package mx.com.officedepot.mypuppy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mx.com.officedepot.mypuppy.pojo.Mascota;

public class RecyclerViewActivity extends Activity {
    private List<Mascota> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.list);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);*/

    }



}