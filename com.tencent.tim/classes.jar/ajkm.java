import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ajkm
  extends RecyclerView.Adapter
{
  private QQAppInterface app;
  private MultiCardRecommendFragment b;
  private boolean isNight;
  public Map<Integer, List<RecommendPerson>> ma;
  
  public ajkm(MultiCardRecommendFragment paramMultiCardRecommendFragment, QQAppInterface paramQQAppInterface)
  {
    this.b = paramMultiCardRecommendFragment;
    this.app = paramQQAppInterface;
    this.ma = new LinkedHashMap(16, 0.75F, false);
    this.isNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  private int Gp()
  {
    return this.ma.size();
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.Adapter", 2, "setTextColorAndSize, needStyleText =" + paramString1 + " totalText =" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramTextView.setText(paramString2);
      return;
    }
    try
    {
      int i = paramString2.indexOf(paramString1);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramString2);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt), i, paramString1.length() + i, 33);
      paramTextView.setText(localSpannableStringBuilder);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramTextView.setText(paramString2);
    }
  }
  
  public void destroy()
  {
    this.ma = null;
    this.app = null;
    this.b = null;
  }
  
  public int getItemCount()
  {
    return this.ma.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.ma == null) || (this.ma.size() == 0)) {}
    Object[] arrayOfObject;
    do
    {
      return 0;
      if (paramInt >= Gp()) {
        return 1;
      }
      arrayOfObject = this.ma.keySet().toArray();
    } while ((arrayOfObject[paramInt] == null) || (!(arrayOfObject[paramInt] instanceof Integer)));
    return ((Integer)arrayOfObject[paramInt]).intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ajkm.d)) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject;
      int i;
      String str1;
      String str2;
      String str3;
      String str4;
      if ((paramViewHolder instanceof ajkm.a))
      {
        localObject = (ajkm.a)paramViewHolder;
        if (((ajkm.a)localObject).Dn.size() > 0) {
          ((ajkm.a)localObject).title.setText(((RecommendPerson)((ajkm.a)localObject).Dn.get(0)).cardMainTitle);
        }
        i = 0;
        while (i < ((ajkm.a)localObject).Do.size()) {
          try
          {
            ajkm.a.a locala = (ajkm.a.a)((ajkm.a)localObject).Do.get(i);
            str1 = ((RecommendPerson)((ajkm.a)localObject).Dn.get(i)).uin;
            str2 = ((RecommendPerson)((ajkm.a)localObject).Dn.get(i)).troopUin;
            str2 = aqgv.h(this.app, str2, str1);
            str3 = ((RecommendPerson)((ajkm.a)localObject).Dn.get(i)).recommendReason;
            str4 = ((RecommendPerson)((ajkm.a)localObject).Dn.get(i)).recommendKeyword;
            locala.E.setImageBitmap(this.b.getFaceBitmap(str1));
            locala.nickName.setText(str2);
            a(locala.UR, str4, str3, locala.nickName.getCurrentTextColor());
            locala.kW.setTag(2131377514, localObject);
            locala.kW.setTag(2131364030, ((ajkm.a)localObject).Dn.get(i));
            locala.kW.setOnTouchListener(jll.a);
            locala.kW.setOnClickListener((View.OnClickListener)localObject);
            locala.gN.setTag(2131377514, localObject);
            locala.gN.setTag(2131364030, ((ajkm.a)localObject).Dn.get(i));
            locala.gN.setOnTouchListener(jll.a);
            locala.gN.setOnClickListener((View.OnClickListener)localObject);
            i += 1;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            for (;;)
            {
              localNumberFormatException1.printStackTrace();
            }
          }
        }
      }
      if ((paramViewHolder instanceof ajkm.c))
      {
        localObject = (ajkm.c)paramViewHolder;
        if (((ajkm.c)localObject).Dp.size() > 0) {
          ((ajkm.c)localObject).title.setText(((RecommendPerson)((ajkm.c)localObject).Dp.get(0)).cardMainTitle);
        }
        i = 0;
        while (i < ((ajkm.c)localObject).Do.size()) {
          try
          {
            ajkm.c.a locala1 = (ajkm.c.a)((ajkm.c)localObject).Do.get(i);
            str1 = ((RecommendPerson)((ajkm.c)localObject).Dp.get(i)).uin;
            str2 = ((RecommendPerson)((ajkm.c)localObject).Dp.get(i)).troopUin;
            str2 = aqgv.h(this.app, str2, str1);
            str3 = ((RecommendPerson)((ajkm.c)localObject).Dp.get(i)).recommendReason;
            str4 = ((RecommendPerson)((ajkm.c)localObject).Dp.get(i)).recommendKeyword;
            locala1.E.setImageBitmap(this.b.getFaceBitmap(str1));
            locala1.nickName.setText(str2);
            a(locala1.UR, str4, str3, locala1.nickName.getCurrentTextColor());
            locala1.kW.setTag(2131377514, localObject);
            locala1.kW.setTag(2131364030, ((ajkm.c)localObject).Dp.get(i));
            locala1.kW.setOnTouchListener(jll.a);
            locala1.kW.setOnClickListener((View.OnClickListener)localObject);
            locala1.gN.setTag(2131377514, localObject);
            locala1.gN.setTag(2131364030, ((ajkm.c)localObject).Dp.get(i));
            locala1.gN.setOnTouchListener(jll.a);
            locala1.gN.setOnClickListener((View.OnClickListener)localObject);
            i += 1;
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            for (;;)
            {
              localNumberFormatException2.printStackTrace();
            }
          }
        }
      }
      if ((paramViewHolder instanceof ajkm.b))
      {
        localObject = (ajkm.b)paramViewHolder;
        if ((this.app != null) && (this.b != null) && (ajkq.a(this.app).a != null)) {
          ((ajkm.b)localObject).US.setText(this.b.getResources().getString(2131721409, new Object[] { Integer.valueOf(ajkq.a(this.app).a.cOi) }));
        }
      }
    }
  }
  
  @RequiresApi(api=23)
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563276, paramViewGroup, false);
      paramViewGroup = new ajkm.d(localView);
    }
    for (;;)
    {
      if ((localView != null) && (localView.getBackground() != null))
      {
        if (!this.isNight) {
          break;
        }
        localView.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP);
      }
      return paramViewGroup;
      if (paramInt == 1)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563273, paramViewGroup, false);
        paramViewGroup = new ajkm.b(localView);
      }
      else if (paramInt == 101)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563271, paramViewGroup, false);
        paramViewGroup = new ajkm.a(localView, paramInt);
      }
      else
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563274, paramViewGroup, false);
        paramViewGroup = new ajkm.c(localView, paramInt);
      }
    }
    localView.getBackground().clearColorFilter();
    return paramViewGroup;
  }
  
  public class a
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    public List<RecommendPerson> Dn;
    public List<ajkm.a.a> Do;
    LinearLayout linearLayout;
    TextView title;
    
    public a(View paramView, int paramInt)
    {
      super();
      this.Dn = ((List)ajkm.this.ma.get(Integer.valueOf(paramInt)));
      if (this.Dn == null) {}
      for (;;)
      {
        return;
        this.Do = new ArrayList(this.Dn.size());
        this.title = ((TextView)paramView.findViewById(2131380999));
        this.linearLayout = ((LinearLayout)paramView.findViewById(2131377513));
        paramView = this.Dn.iterator();
        while (paramView.hasNext())
        {
          Object localObject = (RecommendPerson)paramView.next();
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberRecommend.Adapter", 2, "ActiveViewHolder, person.uin =" + ((RecommendPerson)localObject).uin + " size() = " + this.Dn.size());
          }
          localObject = LayoutInflater.from(this.linearLayout.getContext()).inflate(2131563272, this.linearLayout, false);
          RelativeLayout localRelativeLayout = (RelativeLayout)((View)localObject).findViewById(2131377514);
          ImageView localImageView = (ImageView)((View)localObject).findViewById(2131369938);
          TextView localTextView1 = (TextView)((View)localObject).findViewById(2131381000);
          TextView localTextView2 = (TextView)((View)localObject).findViewById(2131381001);
          Button localButton = (Button)((View)localObject).findViewById(2131364030);
          a(wja.dp2px(85.0F, ajkm.a(ajkm.this).getResources()), this.Dn.size(), localRelativeLayout);
          ajkm.a.a locala = new ajkm.a.a();
          locala.kW = localRelativeLayout;
          locala.E = localImageView;
          locala.nickName = localTextView1;
          locala.UR = localTextView2;
          locala.gN = localButton;
          this.Do.add(locala);
          this.linearLayout.addView((View)localObject);
        }
      }
    }
    
    private void a(int paramInt1, int paramInt2, RelativeLayout paramRelativeLayout)
    {
      if (paramInt2 > 1)
      {
        int i = aqnm.getScreenWidth();
        paramInt2 = (i - paramInt2 * paramInt1) / (paramInt2 * paramInt2);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
        localLayoutParams.leftMargin = paramInt2;
        localLayoutParams.rightMargin = paramInt2;
        paramRelativeLayout.setLayoutParams(localLayoutParams);
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "onCreateViewHolder, rlWidth =" + paramInt1 + " screenWidth =" + i + " margin = " + paramInt2);
        }
      }
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (ajkm.a(ajkm.this) != null)
        {
          ajkm.a(ajkm.this).a((RecyclerView.ViewHolder)paramView.getTag(2131377514), (RecommendPerson)paramView.getTag(2131364030));
          continue;
          if (ajkm.a(ajkm.this) != null) {
            ajkm.a(ajkm.this).b((RecyclerView.ViewHolder)paramView.getTag(2131377514), (RecommendPerson)paramView.getTag(2131364030));
          }
        }
      }
    }
    
    public class a
    {
      public ImageView E;
      TextView UR;
      public Button gN;
      RelativeLayout kW;
      TextView nickName;
      
      a() {}
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    TextView US;
    
    public b(View paramView)
    {
      super();
      this.US = ((TextView)paramView.findViewById(2131380998));
    }
  }
  
  public class c
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    public List<ajkm.c.a> Do;
    public List<RecommendPerson> Dp;
    LinearLayout linearLayout;
    TextView title;
    
    public c(View paramView, int paramInt)
    {
      super();
      this.Dp = ((List)ajkm.this.ma.get(Integer.valueOf(paramInt)));
      if (this.Dp == null) {}
      for (;;)
      {
        return;
        this.Do = new ArrayList(this.Dp.size());
        this.title = ((TextView)paramView.findViewById(2131381002));
        this.linearLayout = ((LinearLayout)paramView.findViewById(2131377515));
        this$1 = this.Dp.iterator();
        while (ajkm.this.hasNext())
        {
          paramView = (RecommendPerson)ajkm.this.next();
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberRecommend.Adapter", 2, "CommonViewHolder, person.uin =" + paramView.uin + " size() = " + this.Dp.size());
          }
          paramView = LayoutInflater.from(this.linearLayout.getContext()).inflate(2131563275, this.linearLayout, false);
          RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131377516);
          ImageView localImageView = (ImageView)paramView.findViewById(2131369939);
          TextView localTextView1 = (TextView)paramView.findViewById(2131381003);
          TextView localTextView2 = (TextView)paramView.findViewById(2131381004);
          Button localButton = (Button)paramView.findViewById(2131364031);
          ajkm.c.a locala = new ajkm.c.a();
          locala.kW = localRelativeLayout;
          locala.E = localImageView;
          locala.nickName = localTextView1;
          locala.UR = localTextView2;
          locala.gN = localButton;
          this.Do.add(locala);
          this.linearLayout.addView(paramView);
        }
      }
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (ajkm.a(ajkm.this) != null)
        {
          ajkm.a(ajkm.this).a((RecyclerView.ViewHolder)paramView.getTag(2131377514), (RecommendPerson)paramView.getTag(2131364030));
          continue;
          if (ajkm.a(ajkm.this) != null) {
            ajkm.a(ajkm.this).b((RecyclerView.ViewHolder)paramView.getTag(2131377514), (RecommendPerson)paramView.getTag(2131364030));
          }
        }
      }
    }
    
    public class a
    {
      public ImageView E;
      TextView UR;
      public Button gN;
      RelativeLayout kW;
      TextView nickName;
      
      a() {}
    }
  }
  
  class d
    extends RecyclerView.ViewHolder
  {
    public d(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajkm
 * JD-Core Version:    0.7.0.1
 */