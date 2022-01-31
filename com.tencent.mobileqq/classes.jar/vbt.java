import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class vbt
  extends vbo
{
  private boolean a;
  
  public vbt(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561509);
  }
  
  private void a(uyg paramuyg, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramuyg);
      return;
      super.b(paramuyg);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramuyg);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramuyg);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(uyg paramuyg)
  {
    if ((paramuyg.jdField_b_of_type_Boolean) || (paramuyg.d > 0))
    {
      b(paramuyg.h);
      if ((!paramuyg.jdField_b_of_type_Boolean) && (paramuyg.d > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        wxe.b("VASH", "bindCoverImage: %s", paramuyg.h);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    b(xsj.b(paramuyg.g));
    wxe.b("VASH", "bindCoverImage: %s", paramuyg.g);
  }
  
  public void a(uyg paramuyg)
  {
    super.a(paramuyg);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramuyg.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (uwm)uwa.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((uwm)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new uxh(String.valueOf(localObject1), "");
        new vdj().a(0, (uxh)localObject2, String.valueOf(localObject1));
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
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = alud.a(2131714173))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramuyg);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramuyg.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramuyg.d) });
      }
      return;
      label223:
      localObject1 = new uxh("", (String)localObject2);
      new vdj().a(1, (uxh)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(uyg paramuyg)
  {
    wxe.b("VASH", "My bindImage of data: %s", String.valueOf(paramuyg));
    if (paramuyg.jdField_b_of_type_Boolean) {
      a(paramuyg, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramuyg);
      return;
      if (paramuyg.d > 0) {
        a(paramuyg, 2);
      } else {
        a(paramuyg, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbt
 * JD-Core Version:    0.7.0.1
 */