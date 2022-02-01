package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class s_picdata
  extends JceStruct
{
  static Map<String, byte[]> cache_binaryExtInfo;
  static Map<Integer, String> cache_busi_param;
  static s_imgcrop cache_cropinfo;
  static ArrayList<stFaceItem> cache_facelist;
  static ArrayList<stFaceItem> cache_facelist_info;
  static stPoi cache_geo;
  static s_LabelInfo cache_label_info;
  static Map<Integer, String> cache_mapExifInfo;
  static Map<String, String> cache_mapExtern;
  static Map<Integer, String> cache_mapOcrInfo;
  static cell_music cache_musicdata;
  static cell_operation cache_operation;
  static ArrayList<stPhotoTag> cache_photoTag;
  static Map<Integer, s_picurl> cache_photourl = new HashMap();
  static s_pic_host cache_pic_host_nick;
  static stPoi cache_poi;
  static Map<Integer, String> cache_shouzhang_extend_map;
  static ArrayList<showdrying_taginfo> cache_vecShowDryingTagInfo;
  static cell_video cache_videodata;
  public String albumid = "";
  public String audio_summary = "";
  public long batchid;
  public Map<String, byte[]> binaryExtInfo;
  public Map<Integer, String> busi_param;
  public String clientkey = "";
  public int commentcount;
  public s_imgcrop cropinfo;
  public String curlikekey = "";
  public String desc = "";
  public ArrayList<stFaceItem> facelist;
  public ArrayList<stFaceItem> facelist_info;
  public String fashion_tag_key = "";
  public int flag;
  public stPoi geo;
  public boolean isAutoPlayGif;
  public boolean isCoverPic;
  public int isIndependentUgc;
  public boolean ismylike;
  public s_LabelInfo label_info;
  public int likecount;
  public String lloc = "";
  public String luckyMoneyDesc = "";
  public Map<Integer, String> mapExifInfo;
  public Map<String, String> mapExtern;
  public Map<Integer, String> mapOcrInfo;
  public long modifytime;
  public cell_music musicdata;
  public cell_operation operation;
  public byte opmask = 7;
  public int opsynflag;
  public String orglikekey = "";
  public long origin_height;
  public long origin_phototype;
  public long origin_size;
  public long origin_width;
  public ArrayList<stPhotoTag> photoTag;
  public Map<Integer, s_picurl> photourl;
  public s_pic_host pic_host_nick;
  public int piccategory;
  public String picname = "";
  public stPoi poi;
  public String quankey = "";
  public int raw;
  public int shoottime;
  public Map<Integer, String> shouzhang_extend_map;
  public String sloc = "";
  public int type;
  public long uUploadTime;
  public long uploadUin;
  public ArrayList<showdrying_taginfo> vecShowDryingTagInfo;
  public cell_video videodata;
  public int videoflag;
  
  static
  {
    Object localObject = new s_picurl();
    cache_photourl.put(Integer.valueOf(0), localObject);
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_cropinfo = new s_imgcrop();
    cache_poi = new stPoi();
    cache_facelist = new ArrayList();
    localObject = new stFaceItem();
    cache_facelist.add(localObject);
    cache_photoTag = new ArrayList();
    localObject = new stPhotoTag();
    cache_photoTag.add(localObject);
    cache_videodata = new cell_video();
    cache_pic_host_nick = new s_pic_host();
    cache_geo = new stPoi();
    cache_operation = new cell_operation();
    cache_musicdata = new cell_music();
    cache_binaryExtInfo = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_binaryExtInfo.put("", localObject);
    cache_vecShowDryingTagInfo = new ArrayList();
    localObject = new showdrying_taginfo();
    cache_vecShowDryingTagInfo.add(localObject);
    cache_shouzhang_extend_map = new HashMap();
    cache_shouzhang_extend_map.put(Integer.valueOf(0), "");
    cache_label_info = new s_LabelInfo();
    cache_facelist_info = new ArrayList();
    localObject = new stFaceItem();
    cache_facelist_info.add(localObject);
    cache_mapOcrInfo = new HashMap();
    cache_mapOcrInfo.put(Integer.valueOf(0), "");
    cache_mapExifInfo = new HashMap();
    cache_mapExifInfo.put(Integer.valueOf(0), "");
    cache_mapExtern = new HashMap();
    cache_mapExtern.put("", "");
  }
  
  public s_picdata() {}
  
  public s_picdata(String paramString1, String paramString2, String paramString3, Map<Integer, s_picurl> paramMap, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, Map<Integer, String> paramMap1, String paramString4, int paramInt4, int paramInt5, long paramLong1, long paramLong2, String paramString5, String paramString6, String paramString7, s_imgcrop params_imgcrop, long paramLong3, int paramInt6, int paramInt7, stPoi paramstPoi1, ArrayList<stFaceItem> paramArrayList1, int paramInt8, boolean paramBoolean2, ArrayList<stPhotoTag> paramArrayList, byte paramByte, String paramString8, int paramInt9, int paramInt10, cell_video paramcell_video, boolean paramBoolean3, s_pic_host params_pic_host, String paramString9, stPoi paramstPoi2, cell_operation paramcell_operation, cell_music paramcell_music, String paramString10, long paramLong4, String paramString11, long paramLong5, long paramLong6, long paramLong7, long paramLong8, Map<String, byte[]> paramMap2, ArrayList<showdrying_taginfo> paramArrayList2, String paramString12, Map<Integer, String> paramMap3, s_LabelInfo params_LabelInfo, ArrayList<stFaceItem> paramArrayList3, Map<Integer, String> paramMap4, Map<Integer, String> paramMap5, Map<String, String> paramMap6)
  {
    this.picname = paramString1;
    this.sloc = paramString2;
    this.lloc = paramString3;
    this.photourl = paramMap;
    this.type = paramInt1;
    this.ismylike = paramBoolean1;
    this.likecount = paramInt2;
    this.commentcount = paramInt3;
    this.busi_param = paramMap1;
    this.clientkey = paramString4;
    this.isIndependentUgc = paramInt4;
    this.opsynflag = paramInt5;
    this.uUploadTime = paramLong1;
    this.modifytime = paramLong2;
    this.desc = paramString5;
    this.orglikekey = paramString6;
    this.curlikekey = paramString7;
    this.cropinfo = params_imgcrop;
    this.uploadUin = paramLong3;
    this.shoottime = paramInt6;
    this.flag = paramInt7;
    this.poi = paramstPoi1;
    this.facelist = paramArrayList1;
    this.raw = paramInt8;
    this.isAutoPlayGif = paramBoolean2;
    this.photoTag = paramArrayList;
    this.opmask = paramByte;
    this.albumid = paramString8;
    this.piccategory = paramInt9;
    this.videoflag = paramInt10;
    this.videodata = paramcell_video;
    this.isCoverPic = paramBoolean3;
    this.pic_host_nick = params_pic_host;
    this.luckyMoneyDesc = paramString9;
    this.geo = paramstPoi2;
    this.operation = paramcell_operation;
    this.musicdata = paramcell_music;
    this.audio_summary = paramString10;
    this.batchid = paramLong4;
    this.quankey = paramString11;
    this.origin_size = paramLong5;
    this.origin_width = paramLong6;
    this.origin_height = paramLong7;
    this.origin_phototype = paramLong8;
    this.binaryExtInfo = paramMap2;
    this.vecShowDryingTagInfo = paramArrayList2;
    this.fashion_tag_key = paramString12;
    this.shouzhang_extend_map = paramMap3;
    this.label_info = params_LabelInfo;
    this.facelist_info = paramArrayList3;
    this.mapOcrInfo = paramMap4;
    this.mapExifInfo = paramMap5;
    this.mapExtern = paramMap6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picname = paramJceInputStream.readString(0, false);
    this.sloc = paramJceInputStream.readString(1, false);
    this.lloc = paramJceInputStream.readString(2, false);
    this.photourl = ((Map)paramJceInputStream.read(cache_photourl, 3, false));
    this.type = paramJceInputStream.read(this.type, 4, false);
    this.ismylike = paramJceInputStream.read(this.ismylike, 5, false);
    this.likecount = paramJceInputStream.read(this.likecount, 6, false);
    this.commentcount = paramJceInputStream.read(this.commentcount, 7, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 8, false));
    this.clientkey = paramJceInputStream.readString(9, false);
    this.isIndependentUgc = paramJceInputStream.read(this.isIndependentUgc, 10, false);
    this.opsynflag = paramJceInputStream.read(this.opsynflag, 11, false);
    this.uUploadTime = paramJceInputStream.read(this.uUploadTime, 12, false);
    this.modifytime = paramJceInputStream.read(this.modifytime, 13, false);
    this.desc = paramJceInputStream.readString(14, false);
    this.orglikekey = paramJceInputStream.readString(15, false);
    this.curlikekey = paramJceInputStream.readString(16, false);
    this.cropinfo = ((s_imgcrop)paramJceInputStream.read(cache_cropinfo, 17, false));
    this.uploadUin = paramJceInputStream.read(this.uploadUin, 18, false);
    this.shoottime = paramJceInputStream.read(this.shoottime, 19, false);
    this.flag = paramJceInputStream.read(this.flag, 20, false);
    this.poi = ((stPoi)paramJceInputStream.read(cache_poi, 21, false));
    this.facelist = ((ArrayList)paramJceInputStream.read(cache_facelist, 22, false));
    this.raw = paramJceInputStream.read(this.raw, 23, false);
    this.isAutoPlayGif = paramJceInputStream.read(this.isAutoPlayGif, 24, false);
    this.photoTag = ((ArrayList)paramJceInputStream.read(cache_photoTag, 25, false));
    this.opmask = paramJceInputStream.read(this.opmask, 26, false);
    this.albumid = paramJceInputStream.readString(27, false);
    this.piccategory = paramJceInputStream.read(this.piccategory, 28, false);
    this.videoflag = paramJceInputStream.read(this.videoflag, 29, false);
    this.videodata = ((cell_video)paramJceInputStream.read(cache_videodata, 30, false));
    this.isCoverPic = paramJceInputStream.read(this.isCoverPic, 31, false);
    this.pic_host_nick = ((s_pic_host)paramJceInputStream.read(cache_pic_host_nick, 32, false));
    this.luckyMoneyDesc = paramJceInputStream.readString(33, false);
    this.geo = ((stPoi)paramJceInputStream.read(cache_geo, 34, false));
    this.operation = ((cell_operation)paramJceInputStream.read(cache_operation, 35, false));
    this.musicdata = ((cell_music)paramJceInputStream.read(cache_musicdata, 36, false));
    this.audio_summary = paramJceInputStream.readString(37, false);
    this.batchid = paramJceInputStream.read(this.batchid, 38, false);
    this.quankey = paramJceInputStream.readString(39, false);
    this.origin_size = paramJceInputStream.read(this.origin_size, 40, false);
    this.origin_width = paramJceInputStream.read(this.origin_width, 41, false);
    this.origin_height = paramJceInputStream.read(this.origin_height, 42, false);
    this.origin_phototype = paramJceInputStream.read(this.origin_phototype, 43, false);
    this.binaryExtInfo = ((Map)paramJceInputStream.read(cache_binaryExtInfo, 44, false));
    this.vecShowDryingTagInfo = ((ArrayList)paramJceInputStream.read(cache_vecShowDryingTagInfo, 45, false));
    this.fashion_tag_key = paramJceInputStream.readString(46, false);
    this.shouzhang_extend_map = ((Map)paramJceInputStream.read(cache_shouzhang_extend_map, 47, false));
    this.label_info = ((s_LabelInfo)paramJceInputStream.read(cache_label_info, 48, false));
    this.facelist_info = ((ArrayList)paramJceInputStream.read(cache_facelist_info, 49, false));
    this.mapOcrInfo = ((Map)paramJceInputStream.read(cache_mapOcrInfo, 50, false));
    this.mapExifInfo = ((Map)paramJceInputStream.read(cache_mapExifInfo, 51, false));
    this.mapExtern = ((Map)paramJceInputStream.read(cache_mapExtern, 52, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picname != null) {
      paramJceOutputStream.write(this.picname, 0);
    }
    if (this.sloc != null) {
      paramJceOutputStream.write(this.sloc, 1);
    }
    if (this.lloc != null) {
      paramJceOutputStream.write(this.lloc, 2);
    }
    if (this.photourl != null) {
      paramJceOutputStream.write(this.photourl, 3);
    }
    paramJceOutputStream.write(this.type, 4);
    paramJceOutputStream.write(this.ismylike, 5);
    paramJceOutputStream.write(this.likecount, 6);
    paramJceOutputStream.write(this.commentcount, 7);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 8);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 9);
    }
    paramJceOutputStream.write(this.isIndependentUgc, 10);
    paramJceOutputStream.write(this.opsynflag, 11);
    paramJceOutputStream.write(this.uUploadTime, 12);
    paramJceOutputStream.write(this.modifytime, 13);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 14);
    }
    if (this.orglikekey != null) {
      paramJceOutputStream.write(this.orglikekey, 15);
    }
    if (this.curlikekey != null) {
      paramJceOutputStream.write(this.curlikekey, 16);
    }
    if (this.cropinfo != null) {
      paramJceOutputStream.write(this.cropinfo, 17);
    }
    paramJceOutputStream.write(this.uploadUin, 18);
    paramJceOutputStream.write(this.shoottime, 19);
    paramJceOutputStream.write(this.flag, 20);
    if (this.poi != null) {
      paramJceOutputStream.write(this.poi, 21);
    }
    if (this.facelist != null) {
      paramJceOutputStream.write(this.facelist, 22);
    }
    paramJceOutputStream.write(this.raw, 23);
    paramJceOutputStream.write(this.isAutoPlayGif, 24);
    if (this.photoTag != null) {
      paramJceOutputStream.write(this.photoTag, 25);
    }
    paramJceOutputStream.write(this.opmask, 26);
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 27);
    }
    paramJceOutputStream.write(this.piccategory, 28);
    paramJceOutputStream.write(this.videoflag, 29);
    if (this.videodata != null) {
      paramJceOutputStream.write(this.videodata, 30);
    }
    paramJceOutputStream.write(this.isCoverPic, 31);
    if (this.pic_host_nick != null) {
      paramJceOutputStream.write(this.pic_host_nick, 32);
    }
    if (this.luckyMoneyDesc != null) {
      paramJceOutputStream.write(this.luckyMoneyDesc, 33);
    }
    if (this.geo != null) {
      paramJceOutputStream.write(this.geo, 34);
    }
    if (this.operation != null) {
      paramJceOutputStream.write(this.operation, 35);
    }
    if (this.musicdata != null) {
      paramJceOutputStream.write(this.musicdata, 36);
    }
    if (this.audio_summary != null) {
      paramJceOutputStream.write(this.audio_summary, 37);
    }
    paramJceOutputStream.write(this.batchid, 38);
    if (this.quankey != null) {
      paramJceOutputStream.write(this.quankey, 39);
    }
    paramJceOutputStream.write(this.origin_size, 40);
    paramJceOutputStream.write(this.origin_width, 41);
    paramJceOutputStream.write(this.origin_height, 42);
    paramJceOutputStream.write(this.origin_phototype, 43);
    if (this.binaryExtInfo != null) {
      paramJceOutputStream.write(this.binaryExtInfo, 44);
    }
    if (this.vecShowDryingTagInfo != null) {
      paramJceOutputStream.write(this.vecShowDryingTagInfo, 45);
    }
    if (this.fashion_tag_key != null) {
      paramJceOutputStream.write(this.fashion_tag_key, 46);
    }
    if (this.shouzhang_extend_map != null) {
      paramJceOutputStream.write(this.shouzhang_extend_map, 47);
    }
    if (this.label_info != null) {
      paramJceOutputStream.write(this.label_info, 48);
    }
    if (this.facelist_info != null) {
      paramJceOutputStream.write(this.facelist_info, 49);
    }
    if (this.mapOcrInfo != null) {
      paramJceOutputStream.write(this.mapOcrInfo, 50);
    }
    if (this.mapExifInfo != null) {
      paramJceOutputStream.write(this.mapExifInfo, 51);
    }
    if (this.mapExtern != null) {
      paramJceOutputStream.write(this.mapExtern, 52);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_picdata
 * JD-Core Version:    0.7.0.1
 */