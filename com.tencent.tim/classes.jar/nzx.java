import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class nzx
  extends BaseAdapter
  implements aqdf.a
{
  public aqdf a;
  private nzu a;
  boolean avR = false;
  boolean avS = false;
  protected List<nzw> kO;
  Activity mActivity;
  QQAppInterface mApp = null;
  
  public nzx(Activity paramActivity, QQAppInterface paramQQAppInterface, nzu paramnzu)
  {
    this.mActivity = paramActivity;
    this.kO = new ArrayList(11);
    this.jdField_a_of_type_Aqdf = new aqdf(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Aqdf.a(this);
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Nzu = paramnzu;
    this.avR = ThemeUtil.isInNightMode(paramQQAppInterface);
    if (Build.MANUFACTURER.toUpperCase().equals("XIAOMI")) {
      this.avS = true;
    }
  }
  
  public void a(nzw paramnzw)
  {
    if (paramnzw != null) {
      this.kO.add(paramnzw);
    }
  }
  
  public void add(List<nzw> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 10) {}
      for (int i = 10;; i = paramList.size())
      {
        int j = 0;
        while (j < i)
        {
          a((nzw)paramList.get(j));
          j += 1;
        }
      }
      paramList = new nzw();
      paramList.uin = -1L;
      a(paramList);
    }
  }
  
  public void clear()
  {
    this.kO.clear();
  }
  
  public void destory()
  {
    this.jdField_a_of_type_Aqdf.a(null);
  }
  
  public int getCount()
  {
    if (this.kO == null) {
      return 0;
    }
    return this.kO.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.kO == null) || (paramInt > getCount()) || (paramInt < 0)) {
      return null;
    }
    return this.kO.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.mActivity.getLayoutInflater().inflate(2131560574, null);
      paramView = new nzx.a(localView, this.avR);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((nzw)this.kO.get(paramInt), paramInt);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      nzx.a locala = (nzx.a)paramView.getTag();
      localView = paramView;
      paramView = locala;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
  
  public class a
  {
    public nzw a;
    public Button aP;
    public ImageView lm;
    public ImageView ln;
    public ImageView lo;
    public ImageView mIconView;
    public View mItemView;
    public TextView mNameView;
    public TextView mTitleView;
    public View nl;
    public View nm;
    public TextView tZ;
    
    public a(View paramView, boolean paramBoolean)
    {
      this.mItemView = paramView;
      this.nl = this.mItemView.findViewById(2131377747);
      this.nm = this.mItemView.findViewById(2131377748);
      this.tZ = ((TextView)this.mItemView.findViewById(2131377750));
      this.lm = ((ImageView)this.mItemView.findViewById(2131377749));
      this.ln = ((ImageView)this.mItemView.findViewById(2131363014));
      this.mTitleView = ((TextView)this.mItemView.findViewById(2131363017));
      this.mIconView = ((ImageView)this.mItemView.findViewById(2131378998));
      this.mNameView = ((TextView)this.mItemView.findViewById(2131378999));
      this.aP = ((Button)this.mItemView.findViewById(2131367378));
      this.lo = ((ImageView)this.mItemView.findViewById(2131367379));
      if (!paramBoolean)
      {
        this.mTitleView.setTextColor(nzx.this.mActivity.getResources().getColor(2131166333));
        this.aP.setBackgroundResource(2130844038);
      }
      for (;;)
      {
        this.aP.setOnClickListener(new nzy(this, nzx.this));
        this.mItemView.setOnClickListener(new nzz(this, nzx.this));
        this.nm.setOnTouchListener(new oaa(this, nzx.this, paramBoolean));
        this.nm.setOnClickListener(new oab(this, nzx.this));
        return;
        this.mTitleView.setTextColor(nzx.this.mActivity.getResources().getColor(2131166334));
        this.aP.setBackgroundResource(2130844037);
      }
    }
    
    private void bcN()
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Nzw.detailUrl))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_Nzx.mActivity, PublicAccountBrowser.class);
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", this.jdField_a_of_type_Nzw.detailUrl);
        localIntent.putExtra("hide_operation_bar", true);
        ocp.f(localIntent, this.jdField_a_of_type_Nzw.detailUrl);
        this.jdField_a_of_type_Nzx.mActivity.startActivity(localIntent);
      }
    }
    
    public void a(nzw paramnzw, int paramInt)
    {
      if (paramnzw == null) {
        return;
      }
      this.jdField_a_of_type_Nzw = paramnzw;
      if (paramnzw.uin == -1L)
      {
        this.nl.setVisibility(8);
        this.nm.setVisibility(0);
        this.lm.setVisibility(0);
        return;
      }
      this.nl.setVisibility(0);
      this.nm.setVisibility(8);
      this.lm.setVisibility(8);
      Object localObject1;
      if (paramnzw.a != null)
      {
        localObject1 = this.ln.getLayoutParams();
        nzx.a(this.jdField_a_of_type_Nzx).a(obs.a(paramnzw.a.mFirstPagePicUrl, 1, Long.valueOf(paramnzw.uin)), this.ln, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
      }
      label152:
      Object localObject2;
      if (paramnzw.a != null)
      {
        localObject1 = paramnzw.a.mTitle.replaceFirst("^\\s+", "");
        localObject2 = localObject1;
        if (this.jdField_a_of_type_Nzx.avS) {
          localObject2 = (String)localObject1 + "\n";
        }
        this.mTitleView.setText((CharSequence)localObject2);
        localObject1 = String.valueOf(paramnzw.uin);
        this.mNameView.setText(paramnzw.name);
        if (AppSetting.enableTalkBack) {
          this.mItemView.setContentDescription(paramnzw.name);
        }
        localObject2 = this.jdField_a_of_type_Nzx.a.b(1, (String)localObject1);
        if (localObject2 != null) {
          break label322;
        }
        this.jdField_a_of_type_Nzx.a.i((String)localObject1, 1, true);
        this.mIconView.setImageResource(2130840645);
      }
      for (;;)
      {
        localObject2 = (acja)this.jdField_a_of_type_Nzx.mApp.getManager(56);
        if (localObject2 == null) {
          break;
        }
        if (((acja)localObject2).c((String)localObject1) == null) {
          break label334;
        }
        ut(1);
        paramnzw.followStatus = 1;
        return;
        localObject1 = "";
        break label152;
        label322:
        this.mIconView.setImageBitmap((Bitmap)localObject2);
      }
      label334:
      if (paramnzw.followStatus == 2)
      {
        ut(2);
        return;
      }
      ut(0);
      paramnzw.followStatus = 0;
    }
    
    public void ut(int paramInt)
    {
      if ((this.lo.isShown()) && ((this.lo.getDrawable() instanceof Animatable))) {
        ((Animatable)this.lo.getDrawable()).stop();
      }
      switch (paramInt)
      {
      default: 
      case 1: 
      case 2: 
        do
        {
          return;
          if (!this.jdField_a_of_type_Nzx.avR) {
            this.aP.setBackgroundResource(2130844035);
          }
          for (;;)
          {
            this.aP.setTextColor(this.jdField_a_of_type_Nzx.mActivity.getResources().getColor(2131166348));
            this.aP.setVisibility(0);
            this.lo.setVisibility(8);
            return;
            this.aP.setBackgroundResource(2130844036);
          }
          this.aP.setVisibility(8);
          this.lo.setVisibility(0);
        } while (!(this.lo.getDrawable() instanceof Animatable));
        ((Animatable)this.lo.getDrawable()).start();
        return;
      }
      if (!this.jdField_a_of_type_Nzx.avR) {
        this.aP.setBackgroundResource(2130844038);
      }
      for (;;)
      {
        this.aP.setTextColor(this.jdField_a_of_type_Nzx.mActivity.getResources().getColor(2131166347));
        this.aP.setVisibility(0);
        this.lo.setVisibility(8);
        return;
        this.aP.setBackgroundResource(2130844037);
      }
    }
  }
  
  public class b
    extends acje
  {
    nzx.a b = null;
    
    public b(nzx.a parama)
    {
      this.b = parama;
    }
    
    public void m(boolean paramBoolean, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.b);
      }
      if (this.b != null)
      {
        paramString = this.b;
        if (!paramBoolean) {
          break label76;
        }
      }
      label76:
      for (int i = 1;; i = 0)
      {
        paramString.ut(i);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzx
 * JD-Core Version:    0.7.0.1
 */