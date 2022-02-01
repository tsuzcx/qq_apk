attribute vec3 position;

uniform mat4 projection;
uniform mat4 view;
varying highp vec3 TexCoords;

void main()
{
    highp vec4 pos = projection * view * vec4(position, 1.0);
    gl_Position = pos.xyww;
    TexCoords = position;
}
