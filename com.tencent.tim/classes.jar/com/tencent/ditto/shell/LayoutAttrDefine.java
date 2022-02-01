package com.tencent.ditto.shell;

import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;

public class LayoutAttrDefine
{
  @DittoJsonElement
  public static final String ABOVE = "above";
  @DittoJsonElement
  public static final String ALIGN_BOTTOM = "alignBottom";
  @DittoJsonElement
  public static final String ALIGN_LEFT = "alignLeft";
  @DittoJsonElement
  public static final String ALIGN_PARENT_BOTTOM = "alignParentBottom";
  @DittoJsonElement
  public static final String ALIGN_PARENT_LEFT = "alignParentLeft";
  @DittoJsonElement
  public static final String ALIGN_PARENT_RIGHT = "alignParentRight";
  @DittoJsonElement
  public static final String ALIGN_PARENT_TOP = "alignParentTop";
  @DittoJsonElement
  public static final String ALIGN_RIGHT = "alignRight";
  @DittoJsonElement
  public static final String ALIGN_TOP = "alignTop";
  @DittoJsonElement
  public static final String ALIGN_WITH_PARENT_IF_MISSING = "alignWithParentIfMissing";
  @DittoJsonElement
  public static final String BELOW = "below";
  @DittoJsonElement(value="背景色", valueStyles={"#AARRGGBB", "#RRGGBB"})
  public static final String BG_Color = "bg_color";
  @DittoJsonElement("背景渐变色方向")
  public static final String BG_GRADIENT_DIRECTION = "bgGradientDir";
  @DittoJsonElement("背景渐变色结束色")
  public static final String BG_GRADIENT_END_COLOR = "bgGradientEndColor";
  @DittoJsonElement("背景渐变色开始色")
  public static final String BG_GRADIENT_START_COLOR = "bgGradientStartColor";
  @DittoJsonElement
  public static final String BorderColor = "border_color";
  @DittoJsonElement
  public static final String BorderRadii4 = "border_radii4";
  @DittoJsonElement
  public static final String BorderRadius = "border_radius";
  @DittoJsonElement
  public static final String BorderWidth = "border_width";
  @DittoJsonElement
  public static final String CENTER_HORIZONTAL = "centerHorizontal";
  @DittoJsonElement
  public static final String CENTER_IN_PARENT = "centerInParent";
  @DittoJsonElement
  public static final String CENTER_VERTICAL = "centerVertical";
  @DittoJsonElement("如果赋值, 点击后会触发handleUri方法, 设置此属性后@CanvasOnClick回调会失效, 在同时有silent_uri和uri时, uri优先级更高")
  public static final String CLICK_URI = "uri";
  @DittoJsonElement("静默wns请求命令字")
  public static final String CMD = "cmd";
  @DittoJsonElement("静默wns请求参数buffer (只是一个key, 从cellUniverse.BgReqData取)")
  public static final String CMD_BUFFER = "cmd_buffer";
  @DittoJsonElement("静默wns请求参数buffer的类型 (由JCE定义的那个)")
  public static final String CMD_BUFFER_TYPE = "cmd_buffer_type";
  @DittoJsonElement
  public static final String COMPASS_CLICK_KEY = "compassClickKey";
  @DittoJsonElement
  public static final String COMPASS_EXPOSURE_KEY = "compassExposureKey";
  @DittoJsonElement(valueStyles={"px", "dp", "match_parent", "wrap_content"})
  public static final String Height = "height";
  @DittoJsonElement("组件id")
  public static final String ID = "id";
  @DittoJsonElement("忽略点击事件, 优先级最高")
  public static final String IGNORE_CLICK = "ignore_click";
  @DittoJsonElement("触发对应控件id的点击事件, 本控件定义的点击相关参数随即失效")
  public static final String INVOKE_AREA_CLICK = "invoke_area_click";
  @DittoJsonElement
  public static final String MARGIN = "margin";
  @DittoJsonElement
  public static final String MARGIN_BOTTOM = "margin_bottom";
  @DittoJsonElement
  public static final String MARGIN_LEFT = "margin_left";
  @DittoJsonElement
  public static final String MARGIN_RIGHT = "margin_right";
  @DittoJsonElement
  public static final String MARGIN_TOP = "margin_top";
  public static final int MatchParent = -1;
  @DittoJsonElement
  public static final String PADDING = "padding";
  @DittoJsonElement
  public static final String PADDING_BOTTOM = "padding_bottom";
  @DittoJsonElement
  public static final String PADDING_LEFT = "padding_left";
  @DittoJsonElement
  public static final String PADDING_RIGHT = "padding_right";
  @DittoJsonElement
  public static final String PADDING_TOP = "padding_top";
  @DittoJsonElement("静默wns请求返回结果如果是修改字段, 这个参数标识了修改字段的keyPath")
  public static final String POST_CLICK_KEY_PATH = "post_click_key_path";
  @DittoJsonElement("点击态透明度")
  public static final String PRESSED_ALPHA = "pressedAlpha";
  public static final String[] RULES_HORIZONTAL = { "toLeftOf", "toRightOf", "alignLeft", "alignRight" };
  public static final String[] RULES_VERTICAL = { "above", "below", "alignTop", "alignBottom" };
  @DittoJsonElement
  public static final String SHRINK_COLUMNS = "shrinkColumns";
  @DittoJsonElement("如果赋值, 点击后会触发handleSilentUri方法, 设置此属性后@CanvasOnClick回调会失效")
  public static final String SILENT_URI = "silent_uri";
  @DittoJsonElement("静默请求完成后的文案 (813后废弃)")
  public static final String SILENT_URI_SENT_TOAST = "silent_uri_sent_toast";
  @DittoJsonElement
  public static final String STRETCH_COLUMNS = "stretchColumns";
  @DittoJsonElement(value="装饰区资源id", valueStyles={"@drawable/id"})
  public static final String ShadowResourceId = "shadow_id";
  @DittoJsonElement(value="装饰区大小, 起点从padding内边界开始计算", valueStyles={"四个方向分别指定(l, t, r, b): 1 px, 2 dp, 3 px, 4 px", "所有方向一致: \"1px\""})
  public static final String ShadowSize = "shadow_size";
  @DittoJsonElement
  public static final String TO_LEFT_OF = "toLeftOf";
  @DittoJsonElement
  public static final String TO_RIGHT_OF = "toRightOf";
  @DittoJsonElement
  public static final String TTT_CLICK_REPORT_KEY = "ttt_report_area";
  @DittoJsonElement(valueStyles={"gone - 不可见, 不参与布局", "visible", "invisible - 不可见, 但是有占位"})
  public static final String VISIBILITY = "visibility";
  @DittoJsonElement("Linear Area Layout 中空白占比的权重")
  public static final String WEIGHT = "weight";
  @DittoJsonElement(valueStyles={"px", "dp", "match_parent", "wrap_content"})
  public static final String Width = "width";
  public static final int WrapContent = -2;
  
  public static class Gravity
  {
    public static final int BOTTOM = 80;
    public static final int CENTER = 17;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_VERTICAL = 16;
    public static final String DEF_BOTTOM = "bottom";
    public static final String DEF_CENTER = "center";
    public static final String DEF_CENTER_HORIZONTAL = "center_horizontal";
    public static final String DEF_CENTER_VERTICAL = "center_vertical";
    public static final String DEF_LEFT = "left";
    public static final String DEF_RIGHT = "right";
    public static final String DEF_TOP = "top";
    public static final String Gravity = "gravity";
    public static final int LEFT = 3;
    public static final String Layout_Gravity = "layout_gravity";
    public static final int NONE = 0;
    public static final int RIGHT = 5;
    public static final int TOP = 48;
    
    public static int parse(String paramString)
    {
      int j = 3;
      int i;
      if ("top".equals(paramString)) {
        i = 48;
      }
      do
      {
        do
        {
          return i;
          if ("bottom".equals(paramString)) {
            return 80;
          }
          i = j;
        } while ("left".equals(paramString));
        if ("right".equals(paramString)) {
          return 5;
        }
        if ("center_vertical".equals(paramString)) {
          return 16;
        }
        if ("center_horizontal".equals(paramString)) {
          return 1;
        }
        i = j;
      } while (!"center".equals(paramString));
      return 17;
    }
  }
  
  public static class Orientation
  {
    public static final String DEF_Horizontal = "horizontal";
    public static final String DEF_Vertical = "vertical";
    public static final int Horizontal = 0;
    public static final String KEY = "orientation";
    public static final int Vertical = 1;
    
    public static int parse(String paramString)
    {
      if ("horizontal".equals(paramString)) {
        return 0;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.shell.LayoutAttrDefine
 * JD-Core Version:    0.7.0.1
 */