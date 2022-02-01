import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.PobingDecoder;
import com.tencent.mobileqq.vas.PobingDecoder.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class xko
  extends RecyclerView.Adapter<xko.b>
  implements ajdq<PobingDecoder.a>, View.OnClickListener
{
  private static final int[][] u;
  private xko.a a;
  private int selected = 2000;
  
  static
  {
    int[] arrayOfInt = { 2001, 2131697013, 2130847937, 1 };
    u = new int[][] { { 2000, 2131697011, 0, 4 }, arrayOfInt, { 2002, 2131697012, 2130847936, 2 }, { 2003, 2131697010, 2130847935, 3 } };
  }
  
  public xko(xko.a parama)
  {
    this.a = parama;
  }
  
  public static int fj(int paramInt)
  {
    int k = 0;
    int[][] arrayOfInt = u;
    int m = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        int[] arrayOfInt1 = arrayOfInt[i];
        if (arrayOfInt1[0] == paramInt) {
          j = arrayOfInt1[3];
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  void Df(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < u.length)
      {
        if (paramInt == u[i][0]) {
          notifyItemChanged(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public xko.b a(ViewGroup paramViewGroup, int paramInt)
  {
    return new xko.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562197, paramViewGroup, false));
  }
  
  public void a(PobingDecoder.a parama)
  {
    BaseApplicationImpl.sImageCache.put(aqsr.gm(parama.id), parama);
    Df(parama.id);
  }
  
  public void a(xko.b paramb, int paramInt)
  {
    boolean bool = true;
    int j = 0;
    Object localObject1 = u[paramInt];
    int k = localObject1[0];
    int i = localObject1[2];
    paramb.nameText.setText(localObject1[1]);
    paramb.oC.setImageResource(i);
    localObject1 = paramb.oC;
    if (i != 0)
    {
      i = 0;
      ((ImageView)localObject1).setVisibility(i);
      localObject1 = (PobingDecoder.a)BaseApplicationImpl.sImageCache.get(aqsr.gm(k));
      paramb.th.setId(k);
      paramb.th.setOnClickListener(this);
      Object localObject2 = paramb.th;
      if (localObject1 == null) {
        break label222;
      }
      label105:
      ((ImageView)localObject2).setClickable(bool);
      localObject2 = paramb.th;
      if (k != this.selected) {
        break label228;
      }
      i = 2130841267;
      label130:
      ((ImageView)localObject2).setImageResource(i);
      localObject2 = paramb.progressBar;
      if (localObject1 != null) {
        break label233;
      }
      i = j;
      label150:
      ((ProgressBar)localObject2).setVisibility(i);
      if (localObject1 == null) {
        break label239;
      }
      localObject2 = paramb.th.getResources();
      paramb.th.setBackgroundDrawable(new BitmapDrawable((Resources)localObject2, (Bitmap)((PobingDecoder.a)localObject1).pg.get(Integer.valueOf(2131373438))));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
      return;
      i = 8;
      break;
      label222:
      bool = false;
      break label105;
      label228:
      i = 0;
      break label130;
      label233:
      i = 8;
      break label150;
      label239:
      paramb.th.setBackgroundDrawable(null);
      new PobingDecoder(k, aqsr.ph, this);
    }
  }
  
  public int getItemCount()
  {
    return u.length;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    setSelected(i);
    anot.a(null, "dc00898", "", "", "qq_vip", "0X800A4F9", fj(i), 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setSelected(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < u.length)
      {
        if (paramInt == u[i][0])
        {
          this.selected = paramInt;
          if (this.a != null) {
            this.a.select(paramInt);
          }
          notifyDataSetChanged();
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public int uG()
  {
    return this.selected;
  }
  
  public static abstract interface a
  {
    public abstract void select(int paramInt);
  }
  
  public static class b
    extends RecyclerView.ViewHolder
  {
    public TextView nameText;
    public ImageView oC;
    public ProgressBar progressBar;
    public ImageView th;
    
    public b(View paramView)
    {
      super();
      this.th = ((ImageView)paramView.findViewById(2131373438));
      this.nameText = ((TextView)paramView.findViewById(2131373437));
      this.oC = ((ImageView)paramView.findViewById(2131373435));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131373439));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xko
 * JD-Core Version:    0.7.0.1
 */