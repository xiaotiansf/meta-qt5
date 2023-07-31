require qt5.inc
require qt5-git.inc

inherit pkgconfig

LICENSE = "GPL-3.0-only | LGPL-3.0-only | The-Qt-Company-Commercial"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPLv3;md5=c4fe8c6de4eef597feec6e90ed62e962 \
    file://LICENSE.GPL;md5=d32239bcb673463ab874e80d47fae504 \
"

DEPENDS += "qtbase qtxmlpatterns qtdeclarative"

PACKAGECONFIG ??= "sdl2"
PACKAGECONFIG[sdl2] = "-feature-sdl2,-no-feature-sdl2,libsdl2"

EXTRA_QMAKEVARS_CONFIGURE += "${PACKAGECONFIG_CONFARGS}"

SRCREV = "708081b4039d8ea2a20e7011e4a7c0b6ec69818c"
