import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.Iterator;
import java.util.List;

public class tiu
  extends tim
{
  public tiu(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = ajyc.a(2131713253);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131373348, null);
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, tfi paramtfi)
  {
    if ((!TextUtils.isEmpty(paramtfi.j)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, paramtfi.j);
      return;
    }
    super.a(paramString, paramBoolean, paramtfi);
  }
  
  public void a(tfi paramtfi)
  {
    super.a(paramtfi);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131373348), paramtfi.jdField_a_of_type_JavaLangString))
    {
      if ((paramtfi.jdField_a_of_type_JavaUtilList == null) || (paramtfi.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label168;
      }
      str = ((tga)paramtfi.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramtfi.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        tga localtga = (tga)localIterator.next();
        if (!localtga.jdField_a_of_type_Boolean) {
          str = localtga.jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      vel.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramtfi.jdField_a_of_type_JavaLangString, "1", "", str });
      this.a.setTag(2131373348, paramtfi.jdField_a_of_type_JavaLangString);
      return;
      continue;
      label168:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tiu
 * JD-Core Version:    0.7.0.1
 */