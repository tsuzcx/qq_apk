import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.presseffect.PressEffectTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class qnu
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private long AO;
  private PressEffectTextView jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
  private qnu.a jdField_a_of_type_Qnu$a;
  private Button cl;
  private String mVid;
  
  public qnu(View paramView)
  {
    super(paramView);
  }
  
  private void sN(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
    int i;
    label42:
    Context localContext;
    if (paramBoolean)
    {
      i = 0;
      ((PressEffectTextView)localObject).setVisibility(i);
      localObject = this.mItemView.getLayoutParams();
      if (!(localObject instanceof LinearLayout.LayoutParams)) {
        break label85;
      }
      localObject = (LinearLayout.LayoutParams)localObject;
      localContext = this.mItemView.getContext();
      if (!paramBoolean) {
        break label101;
      }
    }
    label85:
    label101:
    for (float f = 10.0F;; f = 30.0F)
    {
      ((LinearLayout.LayoutParams)localObject).bottomMargin = rpq.dip2px(localContext, f);
      this.mItemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      i = 8;
      break;
      localObject = new LinearLayout.LayoutParams(-2, -2);
      break label42;
    }
  }
  
  public void N(@NonNull Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_Qnu$a = new qnu.a();
    a(this.jdField_a_of_type_Qnu$a);
  }
  
  public void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject1 = null;
    if ((paramqjq.h == null) || (paramqjq.h.iO == null) || (paramqjq.h.iO.isEmpty()))
    {
      this.mVid = paramStoryVideoItem.mVid;
      hide();
      return;
    }
    paramqjq = paramqjq.h.iO.iterator();
    while (paramqjq.hasNext())
    {
      pux localpux = (pux)paramqjq.next();
      if (TextUtils.equals(paramStoryVideoItem.mVid, localpux.vid))
      {
        Object localObject2 = this.cl;
        int i;
        if (localpux.bkw != 0)
        {
          paramqjq = localpux.avw;
          ((Button)localObject2).setText(paramqjq);
          this.cl.setTag(localpux.avx);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
          paramqjq = localObject1;
          if (localpux.showText != 0) {
            paramqjq = localpux.avy;
          }
          ((PressEffectTextView)localObject2).setText(paramqjq);
          this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTag(localpux.avz);
          if ((localpux.showText == 0) || (TextUtils.isEmpty(localpux.avy))) {
            break label273;
          }
          i = 1;
          label196:
          if ((i != 0) && (!TextUtils.equals(this.mVid, paramStoryVideoItem.mVid)))
          {
            rar.a("play_video", "exp_all_tips", 0, 0, new String[0]);
            this.mVid = paramStoryVideoItem.mVid;
          }
          if ((localpux.showText == 0) || (TextUtils.isEmpty(localpux.avy))) {
            break label278;
          }
        }
        label273:
        label278:
        for (boolean bool = true;; bool = false)
        {
          sN(bool);
          show();
          return;
          paramqjq = null;
          break;
          i = 0;
          break label196;
        }
      }
    }
    this.mVid = paramStoryVideoItem.mVid;
    hide();
  }
  
  public boolean a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramqjq.h != null) && (paramqjq.h.nodeType == 13);
  }
  
  public void dJ(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView = new PressEffectTextView(this.mItemView.getContext(), null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setId(1001);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setPadding(rpq.dip2px(this.mItemView.getContext(), 82.5F), rpq.dip2px(this.mItemView.getContext(), 9.0F), rpq.dip2px(this.mItemView.getContext(), 82.5F), rpq.dip2px(this.mItemView.getContext(), 9.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, rpq.dip2px(this.mItemView.getContext(), 38.0F));
    localLayoutParams.bottomMargin = rpq.dip2px(this.mItemView.getContext(), 4.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)paramView).addView(this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView, localLayoutParams);
    this.cl = new Button(this.mItemView.getContext());
    this.cl.setId(1000);
    this.cl.setGravity(17);
    this.cl.setTextSize(1, 17.0F);
    this.cl.setTextColor(-1);
    this.cl.setBackgroundResource(2130839537);
    this.cl.setOnClickListener(this);
    localLayoutParams = new RelativeLayout.LayoutParams(rpq.dip2px(this.mItemView.getContext(), 220.0F), rpq.dip2px(this.mItemView.getContext(), 40.0F));
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(2, 1001);
    localLayoutParams.bottomMargin = rpq.dip2px(this.mItemView.getContext(), 10.0F);
    ((RelativeLayout)paramView).addView(this.cl, localLayoutParams);
    sN(true);
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Qnu$a != null) {
      b(this.jdField_a_of_type_Qnu$a);
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public String getTag()
  {
    return "NewGuideNodeWidget";
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.AO < 500L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.AO = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(getTag(), 2, new Object[] { "onClick ", Integer.valueOf(paramView.getId()), ", url=", paramView.getTag() });
      }
      Object localObject = paramView.getTag();
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        switch (paramView.getId())
        {
        }
        for (;;)
        {
          if (!((String)localObject).startsWith("mqqapi:")) {
            break label234;
          }
          localObject = aqik.c(QQStoryContext.a(), getActivity(), (String)localObject);
          if (localObject == null) {
            break;
          }
          ((aqhv)localObject).ace();
          break;
          rar.a("play_video", "clk_try", 0, 0, new String[] { localObject, "", "", this.mVid });
          continue;
          rar.a("play_video", "clk_all_tips", 0, 0, new String[] { localObject, "", "", this.mVid });
        }
        label234:
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        getActivity().startActivity(localIntent);
      }
    }
  }
  
  public class a
    extends qjh
  {
    public a() {}
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      if ((paramInt1 == 20000) && (paramInt2 == -1)) {
        qnu.this.getActivity().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qnu
 * JD-Core Version:    0.7.0.1
 */