import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;

public class axnb
  extends RecyclerView.Adapter<axnb.b>
{
  private static boolean cSH;
  private List<axnb.a> MY = new LinkedList();
  private axnb.c a;
  private final int eGe;
  private Context mContext;
  
  public axnb(@NonNull Context paramContext, @Nullable axnb.c paramc)
  {
    this.mContext = paramContext;
    this.a = paramc;
    this.eGe = paramContext.getResources().getDimensionPixelSize(2131296376);
    cSH = axiz.aOK();
  }
  
  @NonNull
  public axnb.b a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new axnb.b(LayoutInflater.from(this.mContext).inflate(2131558613, paramViewGroup, false), this.a, this.eGe);
  }
  
  public void a(@NonNull axnb.b paramb, int paramInt)
  {
    paramb.b((axnb.a)this.MY.get(paramInt), paramInt);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
  }
  
  public void bJ(@NonNull List<axnb.a> paramList)
  {
    this.MY.clear();
    this.MY.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public List<axnb.a> getData()
  {
    return new LinkedList(this.MY);
  }
  
  public int getItemCount()
  {
    return this.MY.size();
  }
  
  public static class a
  {
    public static final List<a> MZ = ;
    public int downloadStatus;
    public final boolean dvv;
    private VsMusicItemInfo e;
    public boolean selected;
    
    public a(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean)
    {
      this(paramVsMusicItemInfo, paramBoolean, false);
    }
    
    public a(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.e = paramVsMusicItemInfo;
      this.selected = paramBoolean1;
      this.downloadStatus = 0;
      this.dvv = paramBoolean2;
    }
    
    @NonNull
    private String HZ()
    {
      if (this.e == null) {
        return "";
      }
      if (this.e.mMusicName == null) {
        return "";
      }
      return this.e.mMusicName;
    }
    
    @NonNull
    private static List<a> hT()
    {
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < 5)
      {
        VsMusicItemInfo localVsMusicItemInfo = new VsMusicItemInfo();
        localVsMusicItemInfo.mSongMid = ("fakeMid" + (i + 1));
        localVsMusicItemInfo.mMusicName = "";
        localVsMusicItemInfo.mUrl = "";
        localVsMusicItemInfo.mAlbumUrl = "";
        localLinkedList.add(new a(localVsMusicItemInfo, false, true));
        i += 1;
      }
      return localLinkedList;
    }
    
    @NonNull
    public String Ia()
    {
      if (this.e == null) {
        return "";
      }
      if (this.e.mUrl == null) {
        return "";
      }
      return this.e.mUrl;
    }
    
    @NonNull
    public String Ib()
    {
      if (this.e == null) {
        return "";
      }
      if (this.e.mAlbumUrl == null) {
        return "";
      }
      return this.e.mAlbumUrl;
    }
    
    public int Rh()
    {
      if (this.e == null) {
        return 0;
      }
      return this.e.musicStart;
    }
    
    public int Ri()
    {
      if (this.e == null) {
        return 0;
      }
      return this.e.musicDuration;
    }
    
    public boolean aPf()
    {
      return TextUtils.isEmpty(getSongMid());
    }
    
    @NonNull
    public String getSongMid()
    {
      if (this.e == null) {
        return "";
      }
      if (this.e.mSongMid == null) {
        return "";
      }
      return this.e.mSongMid;
    }
    
    @NonNull
    public String toString()
    {
      return "{songMid:" + getSongMid() + ", songName:" + HZ() + ", songUrl:" + Ia() + ", selected:" + this.selected + ", downloadStatus:" + this.downloadStatus + "}";
    }
  }
  
  static class b
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private ImageView Is;
    private ImageView It;
    private ImageView Iu;
    private axnb.c a;
    private TextView ahp;
    private FrameLayout cE;
    private FrameLayout cF;
    private axnb.a d;
    private final int eGe;
    private View mItemView;
    private int mPosition;
    
    public b(@NonNull View paramView, @Nullable axnb.c paramc, int paramInt)
    {
      super();
      this.mItemView = paramView;
      this.cE = ((FrameLayout)paramView.findViewById(2131376639));
      this.Is = ((ImageView)paramView.findViewById(2131369816));
      this.cF = ((FrameLayout)paramView.findViewById(2131367181));
      this.It = ((ImageView)paramView.findViewById(2131369820));
      this.Iu = ((ImageView)paramView.findViewById(2131369819));
      this.ahp = ((TextView)paramView.findViewById(2131380811));
      this.cE.setOnClickListener(this);
      this.a = paramc;
      this.eGe = paramInt;
    }
    
    public void b(@NonNull axnb.a parama, int paramInt)
    {
      this.d = parama;
      this.mPosition = paramInt;
      URLDrawable localURLDrawable;
      if (!TextUtils.isEmpty(parama.Ib()))
      {
        this.Is.setVisibility(0);
        if (this.eGe > 0)
        {
          localURLDrawable = aoop.getDrawable(parama.Ib(), this.eGe, this.eGe);
          this.Is.setImageDrawable(localURLDrawable);
          label59:
          if (!parama.selected) {
            break label232;
          }
          this.cF.setVisibility(0);
          this.cF.setBackgroundResource(2131165262);
          if (parama.downloadStatus != 1) {
            break label212;
          }
          this.It.setVisibility(8);
          this.Iu.setVisibility(0);
          label108:
          this.ahp.setTextColor(BaseApplication.getContext().getResources().getColor(2131165272));
          label126:
          if (!TextUtils.isEmpty(axnb.a.a(parama))) {
            break label360;
          }
          parama = "";
          label139:
          this.ahp.setText(parama);
          parama = (ViewGroup.MarginLayoutParams)this.mItemView.getLayoutParams();
          if (paramInt != 0) {
            break label410;
          }
          parama.leftMargin = aqnm.dip2px(5.0F);
        }
      }
      for (parama.rightMargin = (-aqnm.dip2px(10.0F));; parama.rightMargin = (-aqnm.dip2px(10.0F)))
      {
        this.mItemView.setLayoutParams(parama);
        return;
        localURLDrawable = aoop.getDrawable(parama.Ib());
        break;
        this.Is.setVisibility(4);
        break label59;
        label212:
        this.It.setVisibility(0);
        this.Iu.setVisibility(8);
        break label108;
        label232:
        if (parama.dvv)
        {
          this.cF.setVisibility(0);
          this.cF.setBackgroundResource(2131165261);
          this.It.setVisibility(8);
          this.Iu.setVisibility(0);
          this.ahp.setTextColor(BaseApplication.getContext().getResources().getColor(2131165272));
          break label126;
        }
        if (parama.downloadStatus == 1)
        {
          this.cF.setVisibility(0);
          this.cF.setBackgroundResource(2131167599);
          this.Iu.setVisibility(0);
        }
        for (;;)
        {
          this.It.setVisibility(8);
          break;
          this.cF.setVisibility(8);
          this.Iu.setVisibility(8);
        }
        label360:
        if (axnb.a.a(parama).length() > 5)
        {
          parama = axnb.a.a(parama).substring(0, 5) + "...";
          break label139;
        }
        parama = axnb.a.a(parama);
        break label139;
        label410:
        parama.leftMargin = (-aqnm.dip2px(10.0F));
      }
    }
    
    public void onClick(View paramView)
    {
      axnb.c localc;
      axnb.a locala;
      int i;
      if ((paramView.getId() == 2131376639) && (this.d != null) && (!this.d.dvv) && (this.a != null))
      {
        localc = this.a;
        locala = this.d;
        i = getAdapterPosition();
        if (this.d.selected) {
          break label81;
        }
      }
      label81:
      for (boolean bool = true;; bool = false)
      {
        localc.a(locala, i, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(@Nullable axnb.a parama, int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnb
 * JD-Core Version:    0.7.0.1
 */