import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.FrameAnimationState;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.UnlimitedState;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.util.Vector;

public class uyg
  implements View.OnClickListener
{
  private uyg(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getContext() instanceof ChatHistoryForC2C)) {}
    GivingHeartItemBuilder.Holder localHolder;
    MessageForPoke localMessageForPoke;
    Object localObject2;
    label1544:
    label1654:
    label1663:
    do
    {
      do
      {
        do
        {
          return;
          AIOUtils.m = true;
        } while (GivingHeartItemBuilder.a(this.a));
        localHolder = (GivingHeartItemBuilder.Holder)AIOUtils.a(paramView);
        localMessageForPoke = (MessageForPoke)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "poke onClick() is called, type:" + localMessageForPoke.interactType);
        }
        if (126 == localMessageForPoke.interactType)
        {
          if (paramView.findViewById(2131362361).getVisibility() == 0) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!PokeItemHelper.c.contains(Integer.valueOf(localMessageForPoke.subId))) {
              PokeItemHelper.c.add(Integer.valueOf(localMessageForPoke.subId));
            }
            if (!PokeItemHelper.d.contains(Integer.valueOf(localMessageForPoke.subId))) {
              PokeItemHelper.d.add(Integer.valueOf(localMessageForPoke.subId));
            }
            if (!PokeItemHelper.b.contains(Integer.valueOf(localMessageForPoke.subId))) {
              PokeItemHelper.b.add(Integer.valueOf(localMessageForPoke.subId));
            }
            localHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            paramView = (VasQuickUpdateManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183);
            paramView.a(21L, "poke.item.effect." + localMessageForPoke.subId, "getbubbleview");
            paramView.a(21L, "poke.item.res." + localMessageForPoke.subId, "getbubbleview");
            paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
            return;
          }
          if (!PokeItemHelper.a("bubble", localMessageForPoke.subId))
          {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, "资源下载不完整，请下载后再试。", 0).a();
            return;
          }
          if (SpriteUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c == 1) {}
          for (i = 0;; i = 1)
          {
            if (i != 0)
            {
              SpriteCommFunc.a(this.a.b, "vas_poke", true);
              if (QLog.isColorLevel()) {
                QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in click.");
              }
            }
            PokeItemHelper.a(this.a.b, this.a.jdField_a_of_type_AndroidContentContext, localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localHolder, localMessageForPoke.subId, "bubble");
            return;
          }
        }
        if (PokeBigResHandler.a) {
          break;
        }
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, "资源下载中，请稍候再试。", 0).a();
        paramView = (PokeBigResHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(117);
        if ((paramView != null) && (!PokeBigResHandler.a())) {
          paramView.a(true);
        }
      } while (!localMessageForPoke.isSend());
      localMessageForPoke.setPlayed(this.a.b);
      return;
      int i = 0;
      Object localObject3;
      switch (localMessageForPoke.interactType)
      {
      default: 
        paramView = PokeItemAnimationManager.jdField_a_of_type_JavaLangString + "/chuo_icon/chuo_icon_";
        localObject3 = GivingHeartItemBuilder.a(this.a, localMessageForPoke.interactType);
        if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType <= 0) || (localMessageForPoke.interactType > 6)) {
          if (localHolder.jdField_a_of_type_Float == 2.0F)
          {
            paramView = new BitmapFactory.Options();
            paramView.inSampleSize = 1;
            paramView.inMutable = true;
          }
        }
        break;
      }
      for (;;)
      {
        try
        {
          paramView = ImageUtil.a(PokeBigResHandler.b + "/chuo_caidan/chuo_caidan_" + "01.png", paramView);
          localObject1 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), paramView, PokeItemAnimationManager.a().jdField_a_of_type_MqqOsMqqHandler, localMessageForPoke.mFrameState, (String)localObject3, PokeItemHelper.a(this.a.b));
          GivingHeartItemBuilder.a(this.a, (CustomFrameAnimationDrawable)localObject1);
          ((CustomFrameAnimationDrawable)localObject1).a(1);
          if (!localMessageForPoke.isSend())
          {
            if (localMessageForPoke.interactType == 5) {
              break label1654;
            }
            ((CustomFrameAnimationDrawable)localObject1).b();
          }
          ((CustomFrameAnimationDrawable)localObject1).g();
          ((CustomFrameAnimationDrawable)localObject1).a(new uyh(this, localHolder, localMessageForPoke));
          if (localMessageForPoke.interactType == 6) {
            break label1952;
          }
          if ((localMessageForPoke.interactType != 5) || (localHolder.jdField_a_of_type_Float != 2.0F)) {
            break label1663;
          }
          localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localHolder.c.setVisibility(8);
          paramView = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131363491)).a();
          localHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
          paramView.a(localHolder);
          paramView.setListener(this.a);
          return;
          paramView = PokeBigResHandler.c + "/chuo_motion/chuo_motion_";
          i = 35;
          break;
          paramView = PokeBigResHandler.c + "/bixin_motion/bixin_motion_";
          i = 67;
          break;
          paramView = PokeBigResHandler.c + "/zan_motion/zan_motion_";
          i = 20;
          break;
          paramView = PokeBigResHandler.c + "/xinsui_motion/xinsui_motion_";
          i = 50;
          break;
          if (localMessageForPoke.isSend())
          {
            paramView = PokeBigResHandler.c + "/666send_motion/666send_motion_";
            i = 57;
            break;
          }
          paramView = PokeBigResHandler.c + "/666receive_motion/666receive_motion_";
          continue;
          paramView = PokeItemAnimationManager.jdField_a_of_type_JavaLangString + "/dazhao_icon/dazhao_icon_";
        }
        catch (OutOfMemoryError paramView)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, paramView.toString());
          }
          paramView = null;
          continue;
        }
        paramView = ImageUtil.a(this.a.jdField_a_of_type_AndroidContentContext.getResources(), 2130838528);
        Object localObject1 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), paramView, PokeItemAnimationManager.a().jdField_a_of_type_MqqOsMqqHandler, localMessageForPoke.mFrameState, (String)localObject3, PokeItemHelper.a(this.a.b));
        GivingHeartItemBuilder.a((CustomFrameAnimationDrawable)localObject1);
        continue;
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inScaled = true;
        ((BitmapFactory.Options)localObject1).inSampleSize = 1;
        ((BitmapFactory.Options)localObject1).inMutable = true;
        int j;
        for (;;)
        {
          try
          {
            localObject1 = ImageUtil.a(paramView + "01.png", (BitmapFactory.Options)localObject1);
            localObject3 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, PokeItemAnimationManager.a().jdField_a_of_type_MqqOsMqqHandler, localMessageForPoke.mFrameState, (String)localObject3, PokeItemHelper.a(this.a.b));
            ((CustomFrameAnimationDrawable)localObject3).h();
            j = 40;
            if (localMessageForPoke.interactType == 2) {
              j = 30;
            }
            if ((localMessageForPoke.interactType != 4) || (localHolder.jdField_a_of_type_Float != 2.0F)) {
              break label1544;
            }
            k = 0;
            if (k < 20) {
              if (k + 1 < 10)
              {
                ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + "0" + (k + 1) + ".png");
                k += 1;
                continue;
              }
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GivingHeart", 2, localOutOfMemoryError.toString());
            }
            localObject2 = null;
            continue;
            ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + (k + 1) + ".png");
            continue;
            k = 20;
            localObject2 = localObject3;
          }
          if (k >= i) {
            break;
          }
          ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + 21 + ".png");
          k += 1;
        }
        int k = 0;
        localObject2 = localObject3;
        if (k < i)
        {
          if (k + 1 < 10) {
            ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + "0" + (k + 1) + ".png");
          }
          for (;;)
          {
            k += 1;
            break;
            ((CustomFrameAnimationDrawable)localObject3).a(k, j, paramView + (k + 1) + ".png");
          }
          ((CustomFrameAnimationDrawable)localObject2).a(2);
        }
      }
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable((Drawable)localObject2);
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      localHolder.c.setVisibility(8);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if (!localMessageForPoke.mFrameState.a) {
        break;
      }
      ((CustomFrameAnimationDrawable)localObject2).d();
    } while (!QLog.isColorLevel());
    QLog.d("GivingHeart", 2, "[click]resume to play");
    return;
    ((CustomFrameAnimationDrawable)localObject2).c();
    label1806:
    boolean bool2;
    if (localHolder.jdField_a_of_type_Float == 2.0F)
    {
      if (localMessageForPoke.interactType == 2)
      {
        PokeItemAnimationManager.a().a(1);
        PokeItemAnimationManager.a().a(2, 1500L, localMessageForPoke.isSend());
      }
    }
    else if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType == 0))
    {
      paramView = this.a;
      localObject2 = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
      bool2 = localMessageForPoke.isSend();
      if (localHolder.jdField_a_of_type_Float != 2.0F) {
        break label1946;
      }
    }
    label1946:
    for (boolean bool1 = true;; bool1 = false)
    {
      GivingHeartItemBuilder.a(paramView, (Activity)localObject2, bool2, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GivingHeart", 2, "[click]start to play");
      return;
      if (localMessageForPoke.interactType == 3)
      {
        PokeItemAnimationManager.a().a(4);
        PokeItemAnimationManager.a().a(5, 700L);
        break label1806;
      }
      if (localMessageForPoke.interactType != 4) {
        break label1806;
      }
      PokeItemAnimationManager.a().a(13);
      PokeItemAnimationManager.a().a(14, 800L);
      break label1806;
    }
    label1952:
    if ((PokeBigResHandler.a) && (!localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a()))
    {
      paramView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      localObject2 = this.a.jdField_a_of_type_AndroidContentContext;
      if (!localMessageForPoke.isSend())
      {
        bool1 = true;
        label1995:
        paramView.a((Context)localObject2, bool1, PokeItemHelper.a(this.a.b), localHolder.jdField_a_of_type_Float);
      }
    }
    else
    {
      paramView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (localMessageForPoke.isSend()) {
        break label2190;
      }
      bool1 = true;
      label2035:
      paramView.setParams(bool1);
      paramView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (localMessageForPoke.isSend()) {
        break label2196;
      }
    }
    label2190:
    label2196:
    for (bool1 = true;; bool1 = false)
    {
      paramView.setMirror(bool1);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localHolder.c.setVisibility(8);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new uyi(this, localHolder, localMessageForPoke));
      if (localMessageForPoke.mUnlimitedState.a) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("fangdazhao", 2, "[click]start to play");
      }
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.c();
      return;
      bool1 = false;
      break label1995;
      bool1 = false;
      break label2035;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyg
 * JD-Core Version:    0.7.0.1
 */