package oicq.wlogin_sdk.report;

import java.io.PrintWriter;
import java.io.StringWriter;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

public class report_t3
  extends report_t
{
  private static final long serialVersionUID = 1L;
  public int _cmd = 0;
  public int _conn = 0;
  public String _host = new String("");
  public String _ip = new String("");
  public int _net = 0;
  public int _port = 0;
  public int _rlen = 0;
  public int _rst2 = 0;
  public int _slen = 0;
  public String _str = new String("");
  public int _sub = 0;
  public int _try = 0;
  public int _used = 0;
  public int _wap = 0;
  
  public JSONObject toJasonObj()
  {
    try
    {
      localJSONObject = new JSONObject();
      localStringWriter = new StringWriter();
    }
    catch (Exception localException1)
    {
      try
      {
        localJSONObject.put("cmd", String.format("0x%x", new Object[] { Integer.valueOf(this._cmd) }));
        localJSONObject.put("sub", String.format("0x%x", new Object[] { Integer.valueOf(this._sub) }));
        localJSONObject.put("rst2", String.format("%d", new Object[] { Integer.valueOf(this._rst2) }));
        localJSONObject.put("used", String.format("%d", new Object[] { Integer.valueOf(this._used) }));
        localJSONObject.put("try", String.format("%d", new Object[] { Integer.valueOf(this._try) }));
        localJSONObject.put("host", this._host);
        localJSONObject.put("ip", this._ip);
        localJSONObject.put("port", String.format("%d", new Object[] { Integer.valueOf(this._port) }));
        localJSONObject.put("conn", String.format("%d", new Object[] { Integer.valueOf(this._conn) }));
        localJSONObject.put("net", String.format("%d", new Object[] { Integer.valueOf(this._net) }));
        localJSONObject.put("str", this._str);
        localJSONObject.put("rlen", String.format("%d", new Object[] { Integer.valueOf(this._rlen) }));
        localJSONObject.put("slen", String.format("%d", new Object[] { Integer.valueOf(this._slen) }));
        localJSONObject.put("wap", String.format("%d", new Object[] { Integer.valueOf(this._wap) }));
        return localJSONObject;
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject;
        StringWriter localStringWriter;
        PrintWriter localPrintWriter;
        break label332;
      }
      localException1 = localException1;
      localJSONObject = null;
    }
    label332:
    localPrintWriter = new PrintWriter(localStringWriter, true);
    localException1.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    util.LOGD("exception", localStringWriter.toString());
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.report_t3
 * JD-Core Version:    0.7.0.1
 */