require qt5.inc
require qt5-git.inc

LICENSE = "GPL-3.0-only | The-Qt-Company-Commercial"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
"

DEPENDS += "qtbase qtwebsockets"

PACKAGECONFIG ?= "qtdeclarative"
PACKAGECONFIG[qtdeclarative] = ",,qtdeclarative"

do_configure_prepend() {
    # disable qtdeclarative test if it isn't enabled by PACKAGECONFIG
    sed -e 's/^\(qtHaveModule(quick)\)/OE_QTDECLARATIVE_ENABLED:\1/' -i ${S}/src/plugins/platforms/webgl/webgl.pro
}

EXTRA_QMAKEVARS_PRE += "${@bb.utils.contains('PACKAGECONFIG', 'qtdeclarative', 'CONFIG+=OE_QTDECLARATIVE_ENABLED', '', d)}"

SRCREV = "64beacdd2d0f6fe0796bd291c9ab33f206a333c3"
