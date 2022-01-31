import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class uxe
  extends uxf
{
  public uxe(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561491);
  }
  
  private void c(utx paramutx)
  {
    paramutx.d = false;
    uuq.a(QQStoryContext.a()).a(paramutx);
    uvf localuvf = new uvf();
    localuvf.jdField_b_of_type_JavaLangString = paramutx.jdField_a_of_type_JavaLangString;
    localuvf.c = paramutx.jdField_a_of_type_Int;
    localuvf.d = 4;
    localuvf.jdField_b_of_type_Long = paramutx.e;
    ung.a().a(localuvf, null);
  }
  
  public void a(utx paramutx)
  {
    super.a(paramutx);
    if (!TextUtils.isEmpty(paramutx.g)) {
      c(paramutx.g);
    }
    if (!TextUtils.isEmpty(paramutx.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramutx.c)) {}
      for (str = alpo.a(2131707326);; str = paramutx.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, paramutx.j);
        if (paramutx.d) {
          c(paramutx);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(paramutx.c)) {}
    for (String str = alpo.a(2131707325);; str = paramutx.c)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void b(utx paramutx)
  {
    this.a.setDisplayState(6);
    this.a.a(paramutx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxe
 * JD-Core Version:    0.7.0.1
 */