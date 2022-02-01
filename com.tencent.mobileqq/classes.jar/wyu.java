import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class wyu
  extends wyv
{
  public wyu(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561785);
  }
  
  private void c(wvn paramwvn)
  {
    paramwvn.d = false;
    wwg.a(QQStoryContext.a()).a(paramwvn);
    wwv localwwv = new wwv();
    localwwv.jdField_b_of_type_JavaLangString = paramwvn.jdField_a_of_type_JavaLangString;
    localwwv.c = paramwvn.jdField_a_of_type_Int;
    localwwv.d = 4;
    localwwv.jdField_b_of_type_Long = paramwvn.e;
    wow.a().a(localwwv, null);
  }
  
  public void a(wvn paramwvn)
  {
    super.a(paramwvn);
    if (!TextUtils.isEmpty(paramwvn.g)) {
      c(paramwvn.g);
    }
    if (!TextUtils.isEmpty(paramwvn.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramwvn.c)) {}
      for (str = anzj.a(2131705836);; str = paramwvn.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, paramwvn.j);
        if (paramwvn.d) {
          c(paramwvn);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(paramwvn.c)) {}
    for (String str = anzj.a(2131705835);; str = paramwvn.c)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void b(wvn paramwvn)
  {
    this.a.setDisplayState(6);
    this.a.a(paramwvn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyu
 * JD-Core Version:    0.7.0.1
 */