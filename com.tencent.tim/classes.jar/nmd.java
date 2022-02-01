import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nmd
  implements nln
{
  public int a(BaseData paramBaseData)
  {
    return 2;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new nmd.a(LayoutInflater.from(paramContext).inflate(2131560377, null), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.type == 0;
  }
  
  public static class a
    extends nlm
    implements View.OnClickListener
  {
    private KandianUrlImageView X;
    private KandianUrlImageView Y;
    private boolean atm;
    private LinearLayout em;
    private TextView tq;
    private TextView tr;
    private TextView ts;
    private TextView tt;
    private TextView tu;
    private TextView tw;
    
    public a(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      this.tq = ((TextView)paramView.findViewById(2131380976));
      this.tr = ((TextView)paramView.findViewById(2131380540));
      this.tt = ((TextView)paramView.findViewById(2131380556));
      this.ts = ((TextView)paramView.findViewById(2131380555));
      this.tu = ((TextView)paramView.findViewById(2131380557));
      this.tw = ((TextView)paramView.findViewById(2131380715));
      this.X = ((KandianUrlImageView)paramView.findViewById(2131369665));
      this.Y = ((KandianUrlImageView)paramView.findViewById(2131369780));
      paramView.findViewById(2131377419).setOnClickListener(this);
      this.X.setRound(true);
      this.em = ((LinearLayout)paramView.findViewById(2131370664));
      paramBaseData = odc.a(null, wja.dp2px(12.0F, paramView.getResources()), Color.parseColor("#e9ebec"));
      paramView = odc.a(null, wja.dp2px(12.0F, paramView.getResources()), Color.parseColor("#12B7F5"));
      odc.a(this.em, paramView, paramBaseData);
      this.em.setOnClickListener(this);
    }
    
    private void aOg() {}
    
    private void aOi()
    {
      Object localObject;
      ljc localljc;
      long l;
      nme localnme;
      if (!this.atm)
      {
        pQ(true);
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localljc = lbz.a().a();
        localObject = ((QQAppInterface)localObject).getAccount();
        l = getUin();
        localnme = new nme(this);
        if (!ndi.ak(this.g.articleInfo)) {
          break label81;
        }
      }
      label81:
      for (int i = 2;; i = 1)
      {
        localljc.a((String)localObject, l, true, localnme, i);
        return;
      }
    }
    
    private long getUin()
    {
      try
      {
        long l = Long.parseLong(this.g.articleInfo.mSubscribeID);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return 0L;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    
    private void pQ(boolean paramBoolean)
    {
      this.tw.setOnClickListener(this);
      if (paramBoolean)
      {
        this.tw.setTextColor(-4473925);
        this.em.setEnabled(false);
        return;
      }
      this.tw.setTextColor(-1);
      this.em.setEnabled(true);
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean) {}
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        aOi();
        continue;
        aOg();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmd
 * JD-Core Version:    0.7.0.1
 */