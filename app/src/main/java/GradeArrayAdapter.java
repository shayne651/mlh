import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.shayne.mlh.Grades;
import com.example.shayne.mlh.R;

import java.util.List;

/**
 * Created by shayne on 2017-12-02.
 */

public class GradeArrayAdapter extends ArrayAdapter<Grades> {

    public GradeArrayAdapter(Context context, List<Grades> data){
        super(context, R.layout.activity_list_item);
    }

}
