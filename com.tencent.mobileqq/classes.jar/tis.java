import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class tis
  extends tin
{
  private boolean a;
  
  public tis(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561301);
  }
  
  private void a(tff paramtff, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramtff);
      return;
      super.b(paramtff);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramtff);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramtff);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(tff paramtff)
  {
    if ((paramtff.jdField_b_of_type_Boolean) || (paramtff.d > 0))
    {
      b(paramtff.h);
      if ((!paramtff.jdField_b_of_type_Boolean) && (paramtff.d > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        ved.b("VASH", "bindCoverImage: %s", paramtff.h);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    b(vzi.b(paramtff.g));
    ved.b("VASH", "bindCoverImage: %s", paramtff.g);
  }
  
  public void a(tff paramtff)
  {
    super.a(paramtff);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramtff.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (tdl)tcz.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((tdl)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new teg(String.valueOf(localObject1), "");
        new tki().a(0, (teg)localObject2, String.valueOf(localObject1));
      }
      if ((localObject3 == null) || (!((QQUserUIItem)localObject3).isVip())) {
        break label252;
      }
      bool = true;
      label141:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label257;
      }
    }
    label257:
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = ajya.a(2131713789))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramtff);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramtff.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramtff.d) });
      }
      return;
      label223:
      localObject1 = new teg("", (String)localObject2);
      new tki().a(1, (teg)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(tff paramtff)
  {
    ved.b("VASH", "My bindImage of data: %s", String.valueOf(paramtff));
    if (paramtff.jdField_b_of_type_Boolean) {
      a(paramtff, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramtff);
      return;
      if (paramtff.d > 0) {
        a(paramtff, 2);
      } else {
        a(paramtff, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tis
 * JD-Core Version:    0.7.0.1
 */