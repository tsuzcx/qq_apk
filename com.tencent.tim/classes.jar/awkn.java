import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class awkn
{
  private ImageView Bj;
  private View LM;
  private DragFrameLayout a;
  private final Conversation jdField_b_of_type_ComTencentMobileqqActivityConversation;
  private TianShuAccess.AdItem jdField_b_of_type_CooperationVipPbTianShuAccess$AdItem;
  private View mLayout;
  
  public awkn(Conversation paramConversation)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    initView();
  }
  
  private void eEc()
  {
    avor.bI(this.LM);
  }
  
  private void initView()
  {
    this.a = ((DragFrameLayout)this.jdField_b_of_type_ComTencentMobileqqActivityConversation.a().findViewById(2131365363));
    this.LM = this.jdField_b_of_type_ComTencentMobileqqActivityConversation.a().getLayoutInflater().inflate(2131558693, this.a, false);
    this.mLayout = this.LM.findViewById(2131379647);
    this.LM.findViewById(2131379642).setBackgroundColor(this.jdField_b_of_type_ComTencentMobileqqActivityConversation.getResources().getColor(2131165634));
    this.Bj = ((ImageView)this.LM.findViewById(2131379643));
    this.LM.setOnTouchListener(new awko(this));
    ((ImageView)this.LM.findViewById(2131379644)).setOnClickListener(new awkp(this));
  }
  
  private static void jh(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation(localTranslateAnimation);
  }
  
  public void d(TianShuAccess.AdItem paramAdItem)
  {
    Object localObject1 = null;
    if (paramAdItem == null)
    {
      QLog.e("TianshuBigInsertPage", 2, "showLayer with null ");
      return;
    }
    this.jdField_b_of_type_CooperationVipPbTianShuAccess$AdItem = paramAdItem;
    Iterator localIterator = this.jdField_b_of_type_CooperationVipPbTianShuAccess$AdItem.argList.get().iterator();
    paramAdItem = null;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (TianShuAccess.MapEntry)localIterator.next();
      if (((TianShuAccess.MapEntry)localObject2).key.get().equals("image"))
      {
        localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
        paramAdItem = (TianShuAccess.AdItem)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramAdItem;
      paramAdItem = (TianShuAccess.AdItem)localObject2;
      break;
      if (((TianShuAccess.MapEntry)localObject2).key.get().equals("url"))
      {
        localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
        localObject1 = paramAdItem;
        paramAdItem = (TianShuAccess.AdItem)localObject2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TianshuBigInsertPage", 2, "showHongbaoLayer | imgUrl is: " + paramAdItem + " actionUrl: " + (String)localObject1);
        }
        this.Bj.setOnClickListener(new awkq(this, (String)localObject1));
        PreloadManager.a().c(paramAdItem, new awkr(this));
      }
      else
      {
        localObject2 = paramAdItem;
        paramAdItem = (TianShuAccess.AdItem)localObject1;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkn
 * JD-Core Version:    0.7.0.1
 */