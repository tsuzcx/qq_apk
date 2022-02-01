package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cell_id;
import NS_MOBILE_FEEDS.cell_like;
import NS_MOBILE_FEEDS.cell_operation;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PhotoFeedsData
  extends JceStruct
{
  static Album cache_album;
  static ArrayList<Photo> cache_photolist = new ArrayList();
  static cell_comm cache_pss_cell_comm;
  static cell_comment cache_pss_cell_comment = new cell_comment();
  static cell_id cache_pss_cell_id;
  static cell_like cache_pss_cell_like;
  static cell_operation cache_pss_cell_operation;
  public Album album;
  public int appid;
  public ArrayList<Photo> photolist;
  public cell_comm pss_cell_comm;
  public cell_comment pss_cell_comment;
  public cell_id pss_cell_id;
  public cell_like pss_cell_like;
  public cell_operation pss_cell_operation;
  
  static
  {
    Photo localPhoto = new Photo();
    cache_photolist.add(localPhoto);
    cache_album = new Album();
    cache_pss_cell_comm = new cell_comm();
    cache_pss_cell_id = new cell_id();
    cache_pss_cell_operation = new cell_operation();
    cache_pss_cell_like = new cell_like();
  }
  
  public PhotoFeedsData() {}
  
  public PhotoFeedsData(int paramInt, ArrayList<Photo> paramArrayList, Album paramAlbum, cell_comm paramcell_comm, cell_id paramcell_id, cell_operation paramcell_operation, cell_like paramcell_like, cell_comment paramcell_comment)
  {
    this.appid = paramInt;
    this.photolist = paramArrayList;
    this.album = paramAlbum;
    this.pss_cell_comm = paramcell_comm;
    this.pss_cell_id = paramcell_id;
    this.pss_cell_operation = paramcell_operation;
    this.pss_cell_like = paramcell_like;
    this.pss_cell_comment = paramcell_comment;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, false));
    this.album = ((Album)paramJceInputStream.read(cache_album, 2, false));
    this.pss_cell_comm = ((cell_comm)paramJceInputStream.read(cache_pss_cell_comm, 3, false));
    this.pss_cell_id = ((cell_id)paramJceInputStream.read(cache_pss_cell_id, 4, false));
    this.pss_cell_operation = ((cell_operation)paramJceInputStream.read(cache_pss_cell_operation, 5, false));
    this.pss_cell_like = ((cell_like)paramJceInputStream.read(cache_pss_cell_like, 6, false));
    this.pss_cell_comment = ((cell_comment)paramJceInputStream.read(cache_pss_cell_comment, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    if (this.photolist != null) {
      paramJceOutputStream.write(this.photolist, 1);
    }
    if (this.album != null) {
      paramJceOutputStream.write(this.album, 2);
    }
    if (this.pss_cell_comm != null) {
      paramJceOutputStream.write(this.pss_cell_comm, 3);
    }
    if (this.pss_cell_id != null) {
      paramJceOutputStream.write(this.pss_cell_id, 4);
    }
    if (this.pss_cell_operation != null) {
      paramJceOutputStream.write(this.pss_cell_operation, 5);
    }
    if (this.pss_cell_like != null) {
      paramJceOutputStream.write(this.pss_cell_like, 6);
    }
    if (this.pss_cell_comment != null) {
      paramJceOutputStream.write(this.pss_cell_comment, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoFeedsData
 * JD-Core Version:    0.7.0.1
 */