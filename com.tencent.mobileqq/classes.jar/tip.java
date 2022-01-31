import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class tip
  extends tiq
{
  public tip(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561302);
  }
  
  private void c(tfi paramtfi)
  {
    paramtfi.d = false;
    tgb.a(QQStoryContext.a()).a(paramtfi);
    tgq localtgq = new tgq();
    localtgq.jdField_b_of_type_JavaLangString = paramtfi.jdField_a_of_type_JavaLangString;
    localtgq.c = paramtfi.jdField_a_of_type_Int;
    localtgq.d = 4;
    localtgq.jdField_b_of_type_Long = paramtfi.e;
    syr.a().a(localtgq, null);
  }
  
  public void a(tfi paramtfi)
  {
    super.a(paramtfi);
    if (!TextUtils.isEmpty(paramtfi.g)) {
      c(paramtfi.g);
    }
    if (!TextUtils.isEmpty(paramtfi.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramtfi.c)) {}
      for (str = ajyc.a(2131706943);; str = paramtfi.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, paramtfi.j);
        if (paramtfi.d) {
          c(paramtfi);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(paramtfi.c)) {}
    for (String str = ajyc.a(2131706942);; str = paramtfi.c)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void b(tfi paramtfi)
  {
    this.a.setDisplayState(6);
    this.a.a(paramtfi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tip
 * JD-Core Version:    0.7.0.1
 */