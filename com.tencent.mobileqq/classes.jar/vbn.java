import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class vbn
  extends vbo
{
  public vbn(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561509);
  }
  
  private void c(uyg paramuyg)
  {
    paramuyg.d = false;
    uyz.a(QQStoryContext.a()).a(paramuyg);
    uzo localuzo = new uzo();
    localuzo.jdField_b_of_type_JavaLangString = paramuyg.jdField_a_of_type_JavaLangString;
    localuzo.c = paramuyg.jdField_a_of_type_Int;
    localuzo.d = 4;
    localuzo.jdField_b_of_type_Long = paramuyg.e;
    urp.a().a(localuzo, null);
  }
  
  public void a(uyg paramuyg)
  {
    super.a(paramuyg);
    if (!TextUtils.isEmpty(paramuyg.g)) {
      c(paramuyg.g);
    }
    if (!TextUtils.isEmpty(paramuyg.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramuyg.c)) {}
      for (str = alud.a(2131707338);; str = paramuyg.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, paramuyg.j);
        if (paramuyg.d) {
          c(paramuyg);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(paramuyg.c)) {}
    for (String str = alud.a(2131707337);; str = paramuyg.c)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void b(uyg paramuyg)
  {
    this.a.setDisplayState(6);
    this.a.a(paramuyg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbn
 * JD-Core Version:    0.7.0.1
 */