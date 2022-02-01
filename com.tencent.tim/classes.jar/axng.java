import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.LinkedList;
import java.util.List;

public class axng
  extends ReportDialog
  implements DialogInterface.OnShowListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener, axnb.c
{
  private View MM;
  private RecyclerView P;
  private axnb jdField_a_of_type_Axnb;
  private axng.a jdField_a_of_type_Axng$a;
  private TextView ahq;
  private CheckBox aj;
  private CheckBox ak;
  private LinearLayoutManager b;
  private int bhT;
  private FrameLayout cG;
  private boolean cSH;
  private boolean dvw;
  private boolean dvx;
  private View mContentView;
  private boolean mFirstShow = true;
  
  public axng(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, 2131755081);
    this.bhT = paramInt;
    this.cSH = axiz.aOK();
    this.mContentView = LayoutInflater.from(paramContext).inflate(2131558608, null);
    this.ahq = ((TextView)this.mContentView.findViewById(2131380915));
    this.aj = ((CheckBox)this.mContentView.findViewById(2131364358));
    this.ak = ((CheckBox)this.mContentView.findViewById(2131364366));
    this.P = ((RecyclerView)this.mContentView.findViewById(2131377616));
    this.cG = ((FrameLayout)this.mContentView.findViewById(2131367171));
    this.MM = this.mContentView.findViewById(2131381461);
    this.aj.setEnabled(false);
    this.ahq.setOnClickListener(this);
    this.aj.setOnCheckedChangeListener(this);
    this.ak.setOnCheckedChangeListener(this);
    this.cG.setOnClickListener(this);
    setOnShowListener(this);
    this.b = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_Axnb = new axnb(paramContext, this);
    this.P.setLayoutManager(this.b);
    this.P.setAdapter(this.jdField_a_of_type_Axnb);
    this.jdField_a_of_type_Axnb.bJ(axnb.a.MZ);
    if (paramInt == 0) {
      this.MM.setVisibility(8);
    }
    setContentView(this.mContentView);
  }
  
  private boolean aPg()
  {
    if ((this.b == null) || (this.jdField_a_of_type_Axnb == null)) {}
    while (this.jdField_a_of_type_Axnb.getItemCount() == 0) {
      return false;
    }
    return true;
  }
  
  private void eMV()
  {
    if (this.mContentView == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(350L);
    localAnimationSet.setFillAfter(true);
    this.mContentView.startAnimation(localAnimationSet);
  }
  
  private void eMW()
  {
    if (this.mContentView == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(350L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new axnh(this));
    this.mContentView.startAnimation(localAnimationSet);
  }
  
  private int lK(int paramInt)
  {
    int j = this.jdField_a_of_type_Axnb.getItemCount();
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= j - 1);
    return j - 1;
  }
  
  public void a(@NonNull axnb.a parama)
  {
    a(parama, 0, true);
  }
  
  public void a(@Nullable axnb.a parama, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.aj.setChecked(false);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Axng$a != null) {
        this.jdField_a_of_type_Axng$a.a(parama, paramInt);
      }
    } while ((this.aj == null) || (!this.aj.isEnabled()) || (this.aj.isChecked()));
    this.dvx = true;
    this.aj.setChecked(true);
  }
  
  public void a(@Nullable axng.a parama)
  {
    this.jdField_a_of_type_Axng$a = parama;
  }
  
  public void aej(int paramInt)
  {
    if (!aPg()) {
      return;
    }
    paramInt = lK(paramInt);
    this.b.scrollToPosition(paramInt);
  }
  
  public void dismiss()
  {
    if (this.dvw) {
      return;
    }
    if (this.jdField_a_of_type_Axng$a != null) {
      this.jdField_a_of_type_Axng$a.eMO();
    }
    eMW();
  }
  
  @NonNull
  public List<axnb.a> hS()
  {
    if (this.jdField_a_of_type_Axnb != null) {
      return this.jdField_a_of_type_Axnb.getData();
    }
    return new LinkedList();
  }
  
  public void oH(@NonNull List<axnb.a> paramList)
  {
    if (this.jdField_a_of_type_Axnb != null) {
      this.jdField_a_of_type_Axnb.bJ(paramList);
    }
    if ((!CollectionUtils.isEmpty(paramList)) && (!this.aj.isEnabled()))
    {
      this.aj.setEnabled(true);
      if (isShowing()) {
        this.aj.setChecked(true);
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = paramCompoundButton.getId();
    if (i == 2131364358) {
      if (this.dvx) {
        this.dvx = false;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (this.jdField_a_of_type_Axng$a != null)
      {
        this.jdField_a_of_type_Axng$a.Yx(paramBoolean);
        continue;
        if ((i == 2131364366) && (this.jdField_a_of_type_Axng$a != null)) {
          this.jdField_a_of_type_Axng$a.Yy(paramBoolean);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131380915) {
      if (!axiw.Y(paramView)) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Axng$a != null)
      {
        this.jdField_a_of_type_Axng$a.eMN();
        continue;
        if (i == 2131367171) {
          dismiss();
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.gravity = 81;
    if (this.bhT != 0) {}
    for (paramBundle.height = this.bhT;; paramBundle.height = -2)
    {
      paramBundle.width = -1;
      getWindow().setAttributes(paramBundle);
      setCancelable(true);
      setCanceledOnTouchOutside(true);
      return;
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (this.mFirstShow)
    {
      this.mFirstShow = false;
      if ((this.aj != null) && (this.aj.isEnabled()) && (!this.aj.isChecked())) {
        this.aj.setChecked(true);
      }
    }
  }
  
  public void setBackgroundMusicChecked(boolean paramBoolean)
  {
    if (this.aj != null) {
      this.aj.setChecked(paramBoolean);
    }
  }
  
  public void setOriginalSoundChecked(boolean paramBoolean)
  {
    if (this.ak != null) {
      this.ak.setChecked(paramBoolean);
    }
  }
  
  public void show()
  {
    super.show();
    eMV();
  }
  
  public static abstract interface a
  {
    public abstract void Yx(boolean paramBoolean);
    
    public abstract void Yy(boolean paramBoolean);
    
    public abstract void a(@Nullable axnb.a parama, int paramInt);
    
    public abstract void eMN();
    
    public abstract void eMO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axng
 * JD-Core Version:    0.7.0.1
 */