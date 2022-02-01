import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class wpf
  extends wpg
{
  public wpf(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561731);
  }
  
  private void c(wly paramwly)
  {
    paramwly.d = false;
    wmr.a(QQStoryContext.a()).a(paramwly);
    wng localwng = new wng();
    localwng.jdField_b_of_type_JavaLangString = paramwly.jdField_a_of_type_JavaLangString;
    localwng.c = paramwly.jdField_a_of_type_Int;
    localwng.d = 4;
    localwng.jdField_b_of_type_Long = paramwly.e;
    wfi.a().a(localwng, null);
  }
  
  public void a(wly paramwly)
  {
    super.a(paramwly);
    if (!TextUtils.isEmpty(paramwly.g)) {
      c(paramwly.g);
    }
    if (!TextUtils.isEmpty(paramwly.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramwly.c)) {}
      for (str = anvx.a(2131706418);; str = paramwly.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, paramwly.j);
        if (paramwly.d) {
          c(paramwly);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(paramwly.c)) {}
    for (String str = anvx.a(2131706417);; str = paramwly.c)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void b(wly paramwly)
  {
    this.a.setDisplayState(6);
    this.a.a(paramwly);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpf
 * JD-Core Version:    0.7.0.1
 */