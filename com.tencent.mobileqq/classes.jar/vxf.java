import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.List;

public class vxf
{
  public AddressItem a;
  public String a;
  public List<vxh> a;
  public vyl a;
  
  public vxf(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof vxf));
    return TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((vxf)paramObject).jdField_a_of_type_JavaLangString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("GeoHashPhotoGroup=[");
    localStringBuilder1.append("geohashString:").append(this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("picList size:");
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      localStringBuilder2.append(i);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxf
 * JD-Core Version:    0.7.0.1
 */