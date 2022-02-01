import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.videoshelf.model.edit.ShelfNode;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class axih
  extends RecyclerView.Adapter<axih.b>
{
  private static final String TAG = axih.class.getSimpleName();
  private static long lastClickTime;
  private axih.a b;
  private HashMap<Integer, Bitmap> cL = new HashMap();
  private String cUI = "";
  private Context context;
  private double mAspectRatio;
  private boolean mIsHorizontal;
  private List<ShelfNode> mNodeGroupList;
  private int mSelectedPosition;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public axih(Context paramContext, List<ShelfNode> paramList, int paramInt1, int paramInt2)
  {
    this.context = paramContext;
    this.mNodeGroupList = paramList;
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    if (this.mVideoHeight != 0)
    {
      this.mAspectRatio = (this.mVideoWidth / this.mVideoHeight);
      if (this.mAspectRatio < 1.0D) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      this.mIsHorizontal = bool;
      return;
    }
  }
  
  public static boolean qH()
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    if (l - lastClickTime >= 200L) {
      bool = true;
    }
    lastClickTime = l;
    return bool;
  }
  
  public axih.b a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new axih.b(LayoutInflater.from(this.context).inflate(2131558562, paramViewGroup, false));
  }
  
  public void a(axih.a parama)
  {
    this.b = parama;
  }
  
  @TargetApi(21)
  public void a(@NonNull axih.b paramb, int paramInt)
  {
    Object localObject = (ShelfNode)this.mNodeGroupList.get(paramInt);
    if (localObject == null)
    {
      Log.e(TAG, "onBindViewHolder contain null data item");
      EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
      return;
    }
    if (!this.cL.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = BitmapUtils.decodeSampleBitmap(this.context, this.cUI + File.separator + ((ShelfNode)localObject).getCoverUri(), 1);
      this.cL.put(Integer.valueOf(paramInt), localObject);
    }
    paramb.thumb.setImageBitmap((Bitmap)this.cL.get(Integer.valueOf(paramInt)));
    localObject = "0" + (paramInt + 1);
    paramb.ahh.setText((CharSequence)localObject);
    paramb.ahi.setText((CharSequence)localObject);
    if (this.mSelectedPosition == paramInt)
    {
      paramb.Ij.setVisibility(8);
      paramb.Ik.setVisibility(0);
      paramb.ahh.setVisibility(8);
      paramb.ahi.setVisibility(0);
    }
    for (;;)
    {
      paramb.itemView.setOnClickListener(new axii(this, paramInt));
      break;
      paramb.Ij.setVisibility(0);
      paramb.Ik.setVisibility(8);
      paramb.ahh.setVisibility(0);
      paramb.ahi.setVisibility(8);
    }
  }
  
  public void eKs()
  {
    Iterator localIterator = this.cL.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      Bitmap localBitmap = (Bitmap)this.cL.get(Integer.valueOf(i));
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
  }
  
  public void eKx()
  {
    notifyDataSetChanged();
  }
  
  public void f(int paramInt, Bitmap paramBitmap)
  {
    if (!this.cL.containsKey(Integer.valueOf(paramInt))) {
      if (BitmapUtils.isLegal(paramBitmap)) {
        this.cL.put(Integer.valueOf(paramInt), paramBitmap);
      }
    }
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
        localBitmap = (Bitmap)this.cL.get(Integer.valueOf(paramInt));
      } while (!BitmapUtils.isLegal(paramBitmap));
      this.cL.put(Integer.valueOf(paramInt), paramBitmap);
    } while ((!BitmapUtils.isLegal(localBitmap)) || (localBitmap == paramBitmap));
    localBitmap.recycle();
  }
  
  public int getItemCount()
  {
    return this.mNodeGroupList.size();
  }
  
  public void setMaterialPath(String paramString)
  {
    this.cUI = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void adS(int paramInt);
  }
  
  public class b
    extends RecyclerView.ViewHolder
  {
    public ImageView Ij;
    public ImageView Ik;
    public RoundCorneredFrameLayout a;
    public TextView ahh;
    public TextView ahi;
    public FrameLayout cB;
    public ImageView thumb;
    
    public b(View paramView)
    {
      super();
      this.cB = ((FrameLayout)paramView.findViewById(2131381736));
      this.a = ((RoundCorneredFrameLayout)paramView.findViewById(2131369423));
      this.thumb = ((ImageView)paramView.findViewById(2131369461));
      this.thumb.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.Ij = ((ImageView)paramView.findViewById(2131368680));
      this.ahh = ((TextView)paramView.findViewById(2131369464));
      this.Ik = ((ImageView)paramView.findViewById(2131368681));
      this.ahi = ((TextView)paramView.findViewById(2131369465));
    }
    
    public void eKy()
    {
      this.itemView.performClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axih
 * JD-Core Version:    0.7.0.1
 */