package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_lbs;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SummaryInfo
  extends JceStruct
{
  static face_show_info cache_face_show;
  static label_show_info cache_label_show = new label_show_info();
  static cell_lbs cache_poi_info;
  static CategoryPhoto cache_preview_elements;
  static int cache_type = 0;
  public String categoryid = "";
  public face_show_info face_show;
  public label_show_info label_show;
  public long photo_num;
  public cell_lbs poi_info;
  public CategoryPhoto preview_elements;
  public int type;
  public String url = "";
  
  static
  {
    cache_preview_elements = new CategoryPhoto();
    cache_face_show = new face_show_info();
    cache_poi_info = new cell_lbs();
  }
  
  public SummaryInfo() {}
  
  public SummaryInfo(int paramInt, long paramLong, String paramString1, String paramString2, CategoryPhoto paramCategoryPhoto, face_show_info paramface_show_info, cell_lbs paramcell_lbs, label_show_info paramlabel_show_info)
  {
    this.type = paramInt;
    this.photo_num = paramLong;
    this.categoryid = paramString1;
    this.url = paramString2;
    this.preview_elements = paramCategoryPhoto;
    this.face_show = paramface_show_info;
    this.poi_info = paramcell_lbs;
    this.label_show = paramlabel_show_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.photo_num = paramJceInputStream.read(this.photo_num, 1, false);
    this.categoryid = paramJceInputStream.readString(2, false);
    this.url = paramJceInputStream.readString(3, false);
    this.preview_elements = ((CategoryPhoto)paramJceInputStream.read(cache_preview_elements, 4, false));
    this.face_show = ((face_show_info)paramJceInputStream.read(cache_face_show, 5, false));
    this.poi_info = ((cell_lbs)paramJceInputStream.read(cache_poi_info, 6, false));
    this.label_show = ((label_show_info)paramJceInputStream.read(cache_label_show, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.photo_num, 1);
    if (this.categoryid != null) {
      paramJceOutputStream.write(this.categoryid, 2);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 3);
    }
    if (this.preview_elements != null) {
      paramJceOutputStream.write(this.preview_elements, 4);
    }
    if (this.face_show != null) {
      paramJceOutputStream.write(this.face_show, 5);
    }
    if (this.poi_info != null) {
      paramJceOutputStream.write(this.poi_info, 6);
    }
    if (this.label_show != null) {
      paramJceOutputStream.write(this.label_show, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.SummaryInfo
 * JD-Core Version:    0.7.0.1
 */