import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class dmb
  implements Runnable
{
  dmb(dma paramdma, HashMap paramHashMap1, HashMap paramHashMap2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if (!this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey("已下载的音乐")) {
        this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.put("已下载的音乐", new ArrayList());
      }
      ((List)this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.get("已下载的音乐")).addAll((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
      if (!this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_JavaUtilHashMap.get(localObject))) {
        this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
      }
    }
    localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if (!this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey("已下载的视频")) {
        this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.put("已下载的视频", new ArrayList());
      }
      ((List)this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.get("已下载的视频")).addAll((Collection)this.b.get(localObject));
      if (!this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilArrayList.contains(this.b.get(localObject))) {
        this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)this.b.get(localObject));
      }
    }
    localIterator = this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (FileInfo)localIterator.next();
      String str = ((FileInfo)localObject).a();
      if ((str != null) && (str.length() != 0))
      {
        if (!this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
          this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
        }
        ((List)this.jdField_a_of_type_Dma.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localObject);
      }
    }
    this.jdField_a_of_type_Dma.a.i();
    this.jdField_a_of_type_Dma.a.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dmb
 * JD-Core Version:    0.7.0.1
 */