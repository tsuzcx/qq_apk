package me.ele.uetool.colorpicker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import me.ele.uetool.util.JarResource;

public class PresetColorAdapter
  extends RecyclerView.Adapter<ColorHolder>
{
  private ColorHolder chosenHolder;
  private List<Integer> colorList;
  private Context context;
  private HUEPicker huePicker;
  private LayoutInflater layoutInflater;
  
  PresetColorAdapter(Context paramContext)
  {
    this.context = paramContext;
    this.layoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getItemCount()
  {
    if (this.colorList == null) {
      return 0;
    }
    return this.colorList.size();
  }
  
  public void onBindViewHolder(@NonNull ColorHolder paramColorHolder, int paramInt)
  {
    paramColorHolder.setColor(((Integer)this.colorList.get(paramInt)).intValue());
    EventCollector.getInstance().onRecyclerBindViewHolder(paramColorHolder, paramInt, getItemId(paramInt));
  }
  
  @NonNull
  public ColorHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new ColorHolder(this.layoutInflater.inflate(JarResource.getIdByName("layout", "qb_uet_preset_color_item"), paramViewGroup, false));
  }
  
  public void setColorList(List<Integer> paramList)
  {
    this.colorList = paramList;
    notifyDataSetChanged();
  }
  
  public void setHuePicker(HUEPicker paramHUEPicker)
  {
    this.huePicker = paramHUEPicker;
  }
  
  public class ColorHolder
    extends RecyclerView.ViewHolder
  {
    int color;
    boolean isChosen = false;
    RoundView roundView;
    
    public ColorHolder(@NonNull View paramView)
    {
      super();
      this.roundView = ((RoundView)paramView.findViewById(JarResource.getIdByName("id", "round")));
      paramView.setOnClickListener(new PresetColorAdapter.ColorHolder.1(this, PresetColorAdapter.this));
    }
    
    public void setChosen(boolean paramBoolean)
    {
      this.isChosen = paramBoolean;
      this.roundView.setChosen(paramBoolean);
    }
    
    public void setColor(int paramInt)
    {
      this.color = paramInt;
      this.roundView.setBackgroundColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.colorpicker.PresetColorAdapter
 * JD-Core Version:    0.7.0.1
 */