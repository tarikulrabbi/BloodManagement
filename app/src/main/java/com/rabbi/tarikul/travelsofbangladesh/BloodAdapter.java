package com.rabbi.tarikul.travelsofbangladesh;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class BloodAdapter extends RecyclerView.Adapter<BloodAdapter.BloodViewHolder>{

    private Context mContext;
    private List<BloodGroups> bloodList;

    public BloodAdapter(Context mContext, List<BloodGroups> bloodGroups) {
        this.mContext = mContext;
        this.bloodList = bloodGroups;
    }

    @Override
    public BloodViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.sample_view, null);
        BloodViewHolder holder = new BloodViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( BloodViewHolder bloodViewHolder, int position) {

            BloodGroups bloodGroups = bloodList.get(position);

            bloodViewHolder.textTitle.setText(bloodGroups.getTextviewTitle());
            bloodViewHolder.textDetails.setText(bloodGroups.getTextViewDetails());

            bloodViewHolder.imageView.setImageDrawable(mContext.getResources().getDrawable(bloodGroups.getImage(),null));
    }

    @Override
    public int getItemCount() {
        return bloodList.size();
    }

    class BloodViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textTitle, textDetails;
        LinearLayout linearLayout;

        public BloodViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewId);
            textTitle = itemView.findViewById(R.id.bloodNames);
            textDetails = itemView.findViewById(R.id.clickDetailsId);
        }
    }
}
