import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class tit
  extends tiq
{
  public tit(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561302);
  }
  
  public void a()
  {
    this.a.setTag(2131373348, null);
  }
  
  public void a(tfi paramtfi)
  {
    super.a(paramtfi);
    this.a.setDisplayState(2);
    c(paramtfi.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramtfi.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramtfi.c))
      {
        str = ajyc.a(2131713262);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramtfi.j);
        if ((paramtfi.jdField_a_of_type_JavaUtilList == null) || (paramtfi.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramtfi.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131373348);
        if (!TextUtils.equals(paramtfi.jdField_a_of_type_JavaLangString, str)) {
          switch (paramtfi.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      vel.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramtfi.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131373348, paramtfi.jdField_a_of_type_JavaLangString);
      return;
      str = paramtfi.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramtfi.c)) {}
      for (str = ajyc.a(2131713269);; str = paramtfi.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, false);
        break;
      }
      str = "2";
      continue;
      str = "3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tit
 * JD-Core Version:    0.7.0.1
 */