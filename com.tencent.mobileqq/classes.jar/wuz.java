import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class wuz
  extends wva
{
  public wuz(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561744);
  }
  
  private void c(wrs paramwrs)
  {
    paramwrs.d = false;
    wsl.a(QQStoryContext.a()).a(paramwrs);
    wta localwta = new wta();
    localwta.jdField_b_of_type_JavaLangString = paramwrs.jdField_a_of_type_JavaLangString;
    localwta.c = paramwrs.jdField_a_of_type_Int;
    localwta.d = 4;
    localwta.jdField_b_of_type_Long = paramwrs.e;
    wlb.a().a(localwta, null);
  }
  
  public void a(wrs paramwrs)
  {
    super.a(paramwrs);
    if (!TextUtils.isEmpty(paramwrs.g)) {
      c(paramwrs.g);
    }
    if (!TextUtils.isEmpty(paramwrs.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramwrs.c)) {}
      for (str = anni.a(2131705729);; str = paramwrs.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, paramwrs.j);
        if (paramwrs.d) {
          c(paramwrs);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(paramwrs.c)) {}
    for (String str = anni.a(2131705728);; str = paramwrs.c)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void b(wrs paramwrs)
  {
    this.a.setDisplayState(6);
    this.a.a(paramwrs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wuz
 * JD-Core Version:    0.7.0.1
 */