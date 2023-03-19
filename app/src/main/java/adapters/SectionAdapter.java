package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilehealth.R;

import java.util.List;

import models.Section;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Section> sections;

    public SectionAdapter(Context context, List<Section> sections) {
        this.layoutInflater = LayoutInflater.from(context);
        this.sections = sections;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.rv_main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Section section = sections.get(position);
        holder.imgSection.setImageResource(section.getImageResource());
        holder.tvSection.setText(section.getTitle());
        holder.constraintLayout.setBackgroundColor(section.getBackgroundColor());
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgSection;
        private TextView tvSection;
        private ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSection = itemView.findViewById(R.id.rvMainItemImg);
            tvSection = itemView.findViewById(R.id.rvMainItemTV);
            constraintLayout = itemView.findViewById(R.id.rvMainItemConstraintLayout);
        }
}
}
