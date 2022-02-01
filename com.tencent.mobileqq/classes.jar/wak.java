import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class wak
  extends wal
{
  public wak(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561663);
  }
  
  private void c(vxd paramvxd)
  {
    paramvxd.d = false;
    vxw.a(QQStoryContext.a()).a(paramvxd);
    vyl localvyl = new vyl();
    localvyl.jdField_b_of_type_JavaLangString = paramvxd.jdField_a_of_type_JavaLangString;
    localvyl.c = paramvxd.jdField_a_of_type_Int;
    localvyl.d = 4;
    localvyl.jdField_b_of_type_Long = paramvxd.e;
    vqn.a().a(localvyl, null);
  }
  
  public void a(vxd paramvxd)
  {
    super.a(paramvxd);
    if (!TextUtils.isEmpty(paramvxd.g)) {
      c(paramvxd.g);
    }
    if (!TextUtils.isEmpty(paramvxd.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramvxd.c)) {}
      for (str = amtj.a(2131706066);; str = paramvxd.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, paramvxd.j);
        if (paramvxd.d) {
          c(paramvxd);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(paramvxd.c)) {}
    for (String str = amtj.a(2131706065);; str = paramvxd.c)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void b(vxd paramvxd)
  {
    this.a.setDisplayState(6);
    this.a.a(paramvxd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wak
 * JD-Core Version:    0.7.0.1
 */