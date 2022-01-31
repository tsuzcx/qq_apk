import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class tiv
  extends tiq
{
  private boolean a;
  
  public tiv(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561302);
  }
  
  private void a(tfi paramtfi, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramtfi);
      return;
      super.b(paramtfi);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramtfi);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramtfi);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(tfi paramtfi)
  {
    if ((paramtfi.jdField_b_of_type_Boolean) || (paramtfi.d > 0))
    {
      b(paramtfi.h);
      if ((!paramtfi.jdField_b_of_type_Boolean) && (paramtfi.d > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        veg.b("VASH", "bindCoverImage: %s", paramtfi.h);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    b(vzl.b(paramtfi.g));
    veg.b("VASH", "bindCoverImage: %s", paramtfi.g);
  }
  
  public void a(tfi paramtfi)
  {
    super.a(paramtfi);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramtfi.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (tdo)tdc.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((tdo)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new tej(String.valueOf(localObject1), "");
        new tkl().a(0, (tej)localObject2, String.valueOf(localObject1));
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
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = ajyc.a(2131713778))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramtfi);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramtfi.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramtfi.d) });
      }
      return;
      label223:
      localObject1 = new tej("", (String)localObject2);
      new tkl().a(1, (tej)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(tfi paramtfi)
  {
    veg.b("VASH", "My bindImage of data: %s", String.valueOf(paramtfi));
    if (paramtfi.jdField_b_of_type_Boolean) {
      a(paramtfi, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramtfi);
      return;
      if (paramtfi.d > 0) {
        a(paramtfi, 2);
      } else {
        a(paramtfi, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tiv
 * JD-Core Version:    0.7.0.1
 */