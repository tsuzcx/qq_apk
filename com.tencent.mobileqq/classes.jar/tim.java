import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class tim
  extends tin
{
  public tim(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561301);
  }
  
  private void c(tff paramtff)
  {
    paramtff.d = false;
    tfy.a(QQStoryContext.a()).a(paramtff);
    tgn localtgn = new tgn();
    localtgn.jdField_b_of_type_JavaLangString = paramtff.jdField_a_of_type_JavaLangString;
    localtgn.c = paramtff.jdField_a_of_type_Int;
    localtgn.d = 4;
    localtgn.jdField_b_of_type_Long = paramtff.e;
    syo.a().a(localtgn, null);
  }
  
  public void a(tff paramtff)
  {
    super.a(paramtff);
    if (!TextUtils.isEmpty(paramtff.g)) {
      c(paramtff.g);
    }
    if (!TextUtils.isEmpty(paramtff.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramtff.c)) {}
      for (str = ajya.a(2131706954);; str = paramtff.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, paramtff.j);
        if (paramtff.d) {
          c(paramtff);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(paramtff.c)) {}
    for (String str = ajya.a(2131706953);; str = paramtff.c)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void b(tff paramtff)
  {
    this.a.setDisplayState(6);
    this.a.a(paramtff);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tim
 * JD-Core Version:    0.7.0.1
 */