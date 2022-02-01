import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.DrawableImageView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class axdr
  extends RecyclerView.Adapter<axdr.b>
{
  private axdr.a jdField_a_of_type_Axdr$a;
  private axfk jdField_a_of_type_Axfk;
  private axzf jdField_a_of_type_Axzf;
  private Set<Integer> dA;
  private int eEJ;
  private Context mContext;
  private List<axdj> mData;
  private HashMap<String, SoftReference<axff>> ra = new HashMap();
  private View saveBtn;
  
  public axdr(Context paramContext, List<axdj> paramList)
  {
    this.mContext = paramContext;
    this.mData = paramList;
    this.dA = new HashSet();
    this.eEJ = ((int)(DeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.mData != null) && (this.mData.size() != 0))
    {
      ((axdj)this.mData.get(0)).setSelected(true);
      this.dA.add(Integer.valueOf(0));
    }
  }
  
  private void Yc(boolean paramBoolean)
  {
    if (this.saveBtn != null)
    {
      this.saveBtn.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.saveBtn).setText(acfp.m(2131702125));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.saveBtn).setText(acfp.m(2131702135));
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.ra.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (axff)((SoftReference)localObject1).get();; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        if (!TextUtils.isEmpty(paramString))
        {
          Object localObject2 = new File(paramString);
          if (((File)localObject2).exists())
          {
            localObject2 = ((File)localObject2).listFiles();
            if (localObject2.length > 0)
            {
              int i = 0;
              while (i < localObject2.length)
              {
                String str = String.format(paramString + "/frame_%03d.png", new Object[] { Integer.valueOf(i) });
                if (new File(str).exists()) {
                  ((ArrayList)localObject1).add(str);
                }
                i += 1;
              }
            }
          }
        }
        localObject1 = new axff(this.mContext, (ArrayList)localObject1, 55L);
        ((axff)localObject1).setOneShot(false);
        this.ra.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof axff)))
        {
          ((axff)paramImageView.getDrawable()).stop();
          paramImageView.setImageDrawable(null);
        }
        paramImageView.setImageDrawable(paramString);
        paramString.start();
        return;
      }
    }
  }
  
  private void a(AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    if (this.jdField_a_of_type_Axfk != null)
    {
      this.jdField_a_of_type_Axfk.m().a(this.jdField_a_of_type_Axzf, new axdt(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_Axfk.n().a(this.jdField_a_of_type_Axzf, new axdu(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new axdv(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  public Set<Integer> H()
  {
    return this.dA;
  }
  
  public axdr.b a(ViewGroup paramViewGroup, int paramInt)
  {
    return new axdr.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558624, paramViewGroup, false));
  }
  
  public void a(axdr.a parama)
  {
    this.jdField_a_of_type_Axdr$a = parama;
  }
  
  public void a(axdr.b paramb)
  {
    super.onViewRecycled(paramb);
    if ((axdr.b.a(paramb) != null) && (axdr.b.a(paramb).getDrawable() != null) && ((axdr.b.a(paramb).getDrawable() instanceof axff)))
    {
      ((axff)axdr.b.a(paramb).getDrawable()).stop();
      axdr.b.a(paramb).setImageDrawable(null);
    }
  }
  
  public void a(axdr.b paramb, int paramInt)
  {
    axdj localaxdj = (axdj)this.mData.get(paramInt);
    Object localObject = this.mContext.getResources().getDrawable(2130838042);
    localObject = aqqx.a("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    axdr.b.a(paramb).setImageDrawable((Drawable)localObject);
    axdr.b.a(paramb).setVisibility(4);
    paramb.setSelected(localaxdj.aOv());
    switch (localaxdj.state)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = paramb.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.eEJ;
        paramb.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramb.itemView.setOnClickListener(new axds(this, localaxdj, paramInt, paramb));
        EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
        return;
        axdr.b.b(paramb).setVisibility(4);
        axdr.b.a(paramb).setVisibility(0);
      }
    }
    axdr.b.a(paramb).setVisibility(8);
    if (paramInt == 0)
    {
      a(axdr.b.a(paramb));
      axdr.b.a(paramb).setVisibility(0);
    }
    axdr.b.b(paramb).setVisibility(0);
    if (this.dA.contains(Integer.valueOf(paramInt)))
    {
      paramb.setSelected(true);
      Yc(true);
    }
    for (;;)
    {
      localObject = localaxdj.cTP;
      a(axdr.b.a(paramb), (String)localObject, paramInt);
      break;
      paramb.setSelected(false);
    }
  }
  
  public void a(axfk paramaxfk, axzf paramaxzf)
  {
    this.jdField_a_of_type_Axfk = paramaxfk;
    this.jdField_a_of_type_Axzf = paramaxzf;
  }
  
  public int getItemCount()
  {
    return this.mData.size();
  }
  
  public void jn(View paramView)
  {
    this.saveBtn = paramView;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public static abstract interface a
  {
    public abstract void Hi();
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    private ImageView Ia;
    private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
    private DrawableImageView jdField_a_of_type_DovComQqImAeGifGiftextDrawableImageView;
    private RelativeLayout i;
    private ImageView mLoadingView;
    
    public b(View paramView)
    {
      super();
      this.Ia = ((ImageView)paramView.findViewById(2131363983));
      this.i = ((RelativeLayout)paramView.findViewById(2131374672));
      this.jdField_a_of_type_DovComQqImAeGifGiftextDrawableImageView = ((DrawableImageView)paramView.findViewById(2131362307));
      this.mLoadingView = ((ImageView)paramView.findViewById(2131362308));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)paramView.findViewById(2131372763));
    }
    
    public void setSelected(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.Ia.setImageResource(2130838174);
        return;
      }
      this.Ia.setImageResource(2130838017);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdr
 * JD-Core Version:    0.7.0.1
 */