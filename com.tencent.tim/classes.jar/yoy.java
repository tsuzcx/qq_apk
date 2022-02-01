import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class yoy
  extends RecyclerView.Adapter
{
  private boolean bnX;
  private Set<String> bw;
  private aqdf.a c = new yoz(this);
  private FragmentActivity jdField_d_of_type_AndroidSupportV4AppFragmentActivity;
  private aqdf jdField_d_of_type_Aqdf;
  private QQAppInterface mApp;
  private List<ypk> sU;
  private RecyclerView u;
  
  public yoy(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.mApp = paramQQAppInterface;
    this.u = paramRecyclerView;
    this.jdField_d_of_type_Aqdf = new aqdf(paramFragmentActivity, paramQQAppInterface);
    this.jdField_d_of_type_Aqdf.a(this.c);
    this.bnX = anlm.ayn();
    this.bw = new HashSet();
    this.sU = new ArrayList();
  }
  
  private void a(boolean paramBoolean, RecyclerView.ViewHolder paramViewHolder, ypk paramypk)
  {
    int i;
    if (paramBoolean)
    {
      paramypk = (yoy.b)paramViewHolder;
      paramViewHolder = paramypk.up;
      if (this.bnX)
      {
        i = 2130840358;
        paramViewHolder.setImageResource(i);
        paramypk.KX.setText(null);
        paramypk.uin = "";
        paramypk.j.setVisibility(0);
        if (!this.bnX) {
          break label94;
        }
        paramViewHolder = "face2face/jianjie_loading.json";
        label63:
        paramypk.j.setAnimation(paramViewHolder);
        paramypk.j.loop(true);
        paramypk.j.playAnimation();
      }
    }
    label94:
    yoy.a locala;
    do
    {
      return;
      i = 2130840359;
      break;
      paramViewHolder = "face2face/normal_loading.json";
      break label63;
      locala = (yoy.a)paramViewHolder;
    } while ((paramypk == null) || (TextUtils.isEmpty(paramypk.friendUin)));
    locala.up.setImageBitmap(v(paramypk.friendUin));
    locala.up.setOnTouchListener(jll.a);
    locala.up.setOnClickListener(locala);
    if (TextUtils.isEmpty(paramypk.AI))
    {
      paramViewHolder = bj(paramypk.friendUin);
      locala.KX.setText(bj(paramViewHolder));
      locala.uin = paramypk.friendUin;
      if (!paramypk.Ue()) {
        break label319;
      }
      if (!this.bw.contains(paramypk.friendUin))
      {
        locala.up.setAlpha(0.5F);
        locala.j.setVisibility(0);
        if (!this.bnX) {
          break label313;
        }
        paramViewHolder = "face2face/jianjie_avatar.json";
        label250:
        locala.j.setAnimation(paramViewHolder);
        locala.j.playAnimation();
        locala.j.addAnimatorListener(locala);
      }
    }
    for (;;)
    {
      ViewCompat.setImportantForAccessibility(locala.KX, 1);
      ViewCompat.setImportantForAccessibility(locala.up, 1);
      ViewCompat.setImportantForAccessibility(locala.itemView, 1);
      return;
      paramViewHolder = paramypk.AI;
      break;
      label313:
      paramViewHolder = "face2face/normal_avatar.json";
      break label250;
      label319:
      if ((locala.up.getAlpha() < 1.0D) || (locala.j.getVisibility() != 4))
      {
        locala.j.setVisibility(4);
        locala.up.setAlpha(1.0F);
      }
    }
  }
  
  private String bj(String paramString)
  {
    acff localacff = (acff)this.mApp.getManager(51);
    if (localacff == null) {}
    while (!localacff.isFriend(paramString)) {
      return paramString;
    }
    return aqgv.s(this.mApp, paramString);
  }
  
  private void yY(String paramString)
  {
    paramString = new ProfileActivity.AllInOne(paramString, 113);
    paramString.bJa = 126;
    ProfileActivity.b(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity, paramString);
  }
  
  public List<ypk> cQ()
  {
    return this.sU;
  }
  
  public void clearData()
  {
    if (this.bw != null) {
      this.bw.clear();
    }
    if (this.sU != null) {
      this.sU.clear();
    }
  }
  
  public int getItemCount()
  {
    return this.sU.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt >= this.sU.size()) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof yoy.b)) {
      a(true, paramViewHolder, null);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      a(false, paramViewHolder, (ypk)this.sU.get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561367, paramViewGroup, false);
    if (paramInt == 1) {
      return new yoy.b(paramViewGroup);
    }
    return new yoy.a(paramViewGroup);
  }
  
  public void onDestroy()
  {
    this.mApp = null;
    this.jdField_d_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.u = null;
    clearData();
    if (this.jdField_d_of_type_Aqdf != null)
    {
      this.jdField_d_of_type_Aqdf.a(null);
      this.c = null;
      this.jdField_d_of_type_Aqdf.destory();
    }
  }
  
  protected Bitmap v(String paramString)
  {
    Object localObject = null;
    if (this.jdField_d_of_type_Aqdf != null)
    {
      Bitmap localBitmap = this.jdField_d_of_type_Aqdf.b(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_d_of_type_Aqdf.a(paramString, 1, false, (byte)1);
        localObject = localBitmap;
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = aqhu.G();
    }
    return paramString;
  }
  
  class a
    extends RecyclerView.ViewHolder
    implements Animator.AnimatorListener, View.OnClickListener
  {
    TextView KX;
    DiniFlyAnimationView j;
    String uin;
    ImageView up;
    
    public a(View paramView)
    {
      super();
      this.j = ((DiniFlyAnimationView)paramView.findViewById(2131377583));
      this.up = ((ImageView)paramView.findViewById(2131368698));
      this.KX = ((TextView)paramView.findViewById(2131372190));
    }
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      this.j.setVisibility(4);
      this.j.cancelAnimation();
      this.up.setAlpha(1.0F);
      yoy.a(yoy.this).add(this.uin);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        yoy.a(yoy.this, this.uin);
      }
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    TextView KX;
    DiniFlyAnimationView j;
    String uin;
    ImageView up;
    
    public b(View paramView)
    {
      super();
      this.j = ((DiniFlyAnimationView)paramView.findViewById(2131377583));
      this.up = ((ImageView)paramView.findViewById(2131368698));
      this.KX = ((TextView)paramView.findViewById(2131372190));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yoy
 * JD-Core Version:    0.7.0.1
 */