import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class atlb
{
  public static String cGU = "send";
  public static String cGV = "recv";
  public static int eqm = 100;
  public JSONArray U;
  public atlb.a a;
  public long axZ;
  public long aya;
  public long ayb;
  public long ayc;
  public long ayd;
  public long aye;
  public long ayf;
  public long ayg;
  public String cGW;
  public String cGX;
  public String cGY;
  public String cGZ;
  public String cHa;
  public String cHb;
  public String cHc;
  public String cHd;
  public String cHe;
  public String cHf;
  public String cHg;
  public String cHh;
  public int cVN = 1;
  public JSONObject ch;
  public JSONObject cj;
  public int dNU = eqm;
  public boolean dhY;
  public int eqn;
  public int eqo;
  public int eqp;
  public int is_owner;
  public String title;
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("list_info_type", this.eqn);
      localJSONObject.put("title", this.title);
      localJSONObject.put("create_ts", this.axZ);
      localJSONObject.put("last_modify_ts", this.aya);
      localJSONObject.put("doc_type", this.dNU);
      localJSONObject.put("last_modify_uid", this.ayb);
      localJSONObject.put("owner_uid", this.ayc);
      localJSONObject.put("doc_icon", this.cGW);
      localJSONObject.put("doc_type_desc", this.cGX);
      localJSONObject.put("doc_thumbnail", this.cGY);
      localJSONObject.put("domain_id", this.ayd);
      localJSONObject.put("pad_id", this.cGZ);
      localJSONObject.put("owner_nick", this.cHa);
      localJSONObject.put("last_modify_nick", this.cHb);
      localJSONObject.put("is_pinned", this.dhY);
      localJSONObject.put("doc_url", this.cHc);
      localJSONObject.put("doc_policy", this.eqo);
      localJSONObject.put("file_info", this.a.toJson());
      localJSONObject.put("team_info", this.ch);
      localJSONObject.put("doc_privilege", this.cj);
      localJSONObject.put("last_pinned_ts", this.aye);
      localJSONObject.put("is_owner", this.is_owner);
      localJSONObject.put("creator_domain", this.cHd);
      localJSONObject.put("parent_folder_id", this.cHe);
      localJSONObject.put("folder_id", this.cHf);
      localJSONObject.put("last_browse_ts", this.ayf);
      localJSONObject.put("last_delete_ts", this.ayg);
      localJSONObject.put("is_collected", this.cHg);
      localJSONObject.put("last_collect_ts", this.cHh);
      localJSONObject.put("relative_doc", this.U);
      localJSONObject.put("from_type", this.cVN);
      localJSONObject.put("local_search_type", this.eqp);
      localJSONObject.put("local_info", atlb.a.a(this.a));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static class a
  {
    public long ayh;
    public long ayi;
    public String cHi;
    public String cHj;
    public String cHk;
    public String cHl;
    public String cHm;
    public String cHn = atlb.cGV;
    private JSONObject ck;
    public long duration;
    public String fileName;
    public long fileSize;
    public int fileType;
    public long file_size;
    public int file_type;
    public int height;
    public long historyId;
    public long historySeq;
    public String localPath;
    public long operateTime;
    public int operateType;
    public int sourceType = 0;
    public int width;
    
    public JSONObject toJson()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("file_size", this.file_size);
        localJSONObject.put("file_type", this.file_type);
        localJSONObject.put("take_time", this.ayh);
        localJSONObject.put("width", this.width);
        localJSONObject.put("height", this.height);
        localJSONObject.put("duration", this.duration);
        this.ck = new JSONObject();
        this.ck.put("session_id", this.ayi);
        this.ck.put("historyId", this.historyId);
        this.ck.put("historySeq", this.historySeq);
        this.ck.put("fileName", this.fileName);
        this.ck.put("file_size", this.fileSize);
        this.ck.put("operateTime", this.operateTime);
        this.ck.put("operateType", this.operateType);
        this.ck.put("localPath", this.localPath);
        this.ck.put("sourceType", this.sourceType);
        this.ck.put("fileType", this.fileType);
        this.ck.put("fileSha", this.cHi);
        this.ck.put("fileExtInfo", this.cHj);
        this.ck.put("fileIdBytes", this.cHk);
        this.ck.put("peer_uin", this.cHl);
        this.ck.put("peer_nick", this.cHm);
        this.ck.put("peer_operation", this.cHn);
        localJSONObject.put("local_info", this.ck);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlb
 * JD-Core Version:    0.7.0.1
 */