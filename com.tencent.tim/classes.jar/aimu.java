import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

public class aimu
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int OE;
  private auwd jdField_a_of_type_Auwd;
  private zjp jdField_a_of_type_Zjp;
  private boolean brr;
  private int ddR;
  private Drawable eU;
  private Context mContext;
  private GridLayoutManager mLayoutManager;
  
  public aimu(Context paramContext, zjp paramzjp)
  {
    this.mContext = paramContext;
    this.eU = paramContext.getResources().getDrawable(2130846249);
    this.ddR = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.OE = wja.dp2px(32.0F, paramContext.getResources());
    this.jdField_a_of_type_Zjp = paramzjp;
  }
  
  public void BJ(boolean paramBoolean)
  {
    this.brr = paramBoolean;
  }
  
  public void a(aimu.a parama, aimt paramaimt)
  {
    if ((paramaimt.g == null) || (paramaimt.g.a == null))
    {
      parama.itemView.setEnabled(false);
      parama.itemView.setOnLongClickListener(null);
      aimu.a.a(parama).setVisibility(8);
      aimu.a.a(parama).setVisibility(8);
      aimu.a.a(parama).setEnabled(false);
      aimu.a.a(parama).setOnClickListener(null);
      aimu.a.a(parama).setVisibility(8);
      if (AppSetting.enableTalkBack) {
        aqcl.changeAccessibilityForView(aimu.a.a(parama), "", Button.class.getName());
      }
    }
    label157:
    label303:
    label441:
    for (;;)
    {
      return;
      parama.itemView.setEnabled(true);
      Object localObject;
      if ((this.brr) && (paramaimt.g.isOpen()))
      {
        parama.itemView.setOnLongClickListener(new aimv(this, parama));
        if (!TextUtils.isEmpty(paramaimt.g.a.strResName)) {
          break label303;
        }
        localObject = "";
        aimu.a.a(parama).setVisibility(0);
        aimu.a.a(parama).setText((CharSequence)localObject);
        localObject = paramaimt.g.a.strGridIconUrl;
        aimu.a.a(parama).setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label317;
        }
        aimu.a.a(parama).setImageDrawable(this.eU);
        label210:
        aimu.a.a(parama).setEnabled(true);
        aimu.a.a(parama).setVisibility(0);
        if (!paramaimt.g.isOpen()) {
          break label404;
        }
        aimu.a.a(parama).setOnClickListener(new aimw(this, paramaimt, parama));
        aimu.a.a(parama).setImageResource(2130851295);
      }
      for (paramaimt = this.mContext.getString(2131695241);; paramaimt = this.mContext.getString(2131695240))
      {
        if (!AppSetting.enableTalkBack) {
          break label441;
        }
        aqcl.changeAccessibilityForView(aimu.a.a(parama), paramaimt, Button.class.getName());
        return;
        parama.itemView.setOnLongClickListener(null);
        break;
        localObject = paramaimt.g.a.strResName;
        break label157;
        label317:
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.OE;
        localURLDrawableOptions.mRequestHeight = this.OE;
        localURLDrawableOptions.mLoadingDrawable = this.eU;
        localURLDrawableOptions.mFailedDrawable = this.eU;
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(this.ddR);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        ((URLDrawable)localObject).setColorFilter(-1, PorterDuff.Mode.DST_IN);
        aimu.a.a(parama).setImageDrawable((Drawable)localObject);
        break label210;
        aimu.a.a(parama).setOnClickListener(new aimx(this, paramaimt, parama));
        aimu.a.a(parama).setImageResource(2130851293);
      }
    }
  }
  
  public void a(GridLayoutManager paramGridLayoutManager)
  {
    this.mLayoutManager = paramGridLayoutManager;
  }
  
  public void a(auwd paramauwd)
  {
    this.jdField_a_of_type_Auwd = paramauwd;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_Zjp.getItemCount();
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_Zjp.getItemViewType(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    aimt localaimt = this.jdField_a_of_type_Zjp.a(paramInt);
    if (localaimt == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof aimu.b)) {
        ((aimu.b)paramViewHolder).a(localaimt);
      } else if ((paramViewHolder instanceof aimu.a)) {
        a((aimu.a)paramViewHolder, localaimt);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561408, paramViewGroup, false);
      paramViewGroup.setTag(2131370337, Integer.valueOf(paramInt));
      return new aimu.b(this.mContext, paramViewGroup);
    }
    if (paramInt == 2)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561407, paramViewGroup, false);
      paramViewGroup.setTag(2131370337, Integer.valueOf(paramInt));
      return new aimu.a(paramViewGroup, this.mContext, this.mLayoutManager);
    }
    return null;
  }
  
  public static class a
    extends RecyclerView.ViewHolder
  {
    private ImageView AK;
    private TextView Ug;
    private ThemeImageView h;
    private RelativeLayout kP;
    
    public a(View paramView, Context paramContext, GridLayoutManager paramGridLayoutManager)
    {
      super();
      this.Ug = ((TextView)paramView.findViewById(2131380814));
      this.h = ((ThemeImageView)paramView.findViewById(2131369780));
      this.h.setMaskShape(auvj.euM);
      this.AK = ((ImageView)paramView.findViewById(2131369650));
      this.kP = ((RelativeLayout)paramView.findViewById(2131377395));
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        this.kP.setBackgroundColor(paramContext.getResources().getColor(2131165929));
        this.Ug.setTextColor(paramContext.getResources().getColor(2131165931));
      }
      while ((paramGridLayoutManager != null) && (paramGridLayoutManager.getWidth() > 0))
      {
        paramView = this.kP.getLayoutParams();
        paramView.height = (paramGridLayoutManager.getWidth() / 3);
        this.kP.setLayoutParams(paramView);
        if (QLog.isColorLevel()) {
          QLog.i("leba_sort_LebaTableMgrAdpter", 2, "plugin height =" + paramView.height);
        }
        return;
        this.kP.setBackgroundColor(paramContext.getResources().getColor(2131165928));
        this.Ug.setTextColor(paramContext.getResources().getColor(2131165930));
      }
      QLog.i("leba_sort_LebaTableMgrAdpter", 1, "plugin getWidth error ");
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
  {
    private TextView oq;
    
    public b(Context paramContext, View paramView)
    {
      super();
      this.oq = ((TextView)paramView.findViewById(2131379769));
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        this.oq.setTextColor(paramContext.getResources().getColor(2131165933));
        return;
      }
      this.oq.setTextColor(paramContext.getResources().getColor(2131165932));
    }
    
    public void a(aimt paramaimt)
    {
      if (TextUtils.isEmpty(paramaimt.title))
      {
        this.oq.setVisibility(8);
        return;
      }
      this.oq.setVisibility(0);
      this.oq.setText(paramaimt.title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aimu
 * JD-Core Version:    0.7.0.1
 */