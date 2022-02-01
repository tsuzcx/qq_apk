import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;

public class aqfx
  implements QAlbumCustomAlbumConstants
{
  public static final String ALBUM_ID;
  public static final String ALBUM_NAME;
  public static final String FROM_WHERE_KEY;
  private static final String PREFIX = aqfx.class.getName() + ".";
  public static final String REQUEST_CODE = PREFIX + "RequestCode";
  public static final String csG = PREFIX + "SelectedPhotoList";
  public static final String csH = PREFIX + "ForwardWhere";
  public static final String csI;
  public static final String csJ;
  public static final String csK = PREFIX + "TempSelectPhotoMap";
  public static final String csL = PREFIX + "PassToDestActivity";
  public static final String csM = PREFIX + "PassFromDestActivity";
  
  static
  {
    FROM_WHERE_KEY = PREFIX + "FromWhere";
    ALBUM_NAME = PREFIX + "AlbumName";
    ALBUM_ID = PREFIX + "AlbumId";
    csI = PREFIX + "InitActivityClass";
    csJ = PREFIX + "DestActivityClass";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfx
 * JD-Core Version:    0.7.0.1
 */