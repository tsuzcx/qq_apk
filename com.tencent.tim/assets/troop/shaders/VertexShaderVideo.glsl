attribute vec4 vPosition;
attribute vec4 vTexCoordinate;
attribute vec4 vTexAlphaCoordinate;
uniform mat4 textureTransform;
varying vec2 v_TexCoordinate;
varying vec2 v_TexAlphaCoordinate;
void main () {
    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;
    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;
    gl_Position = vPosition;
}
