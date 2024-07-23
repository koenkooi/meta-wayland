SUMMARY = "A wlroots-compatible Wayland color picker that does not suck."
HOMEPAGE = "https://hyprland.org/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=936078e4e67b0e1e1bd1e862d4ffbc25"

SRC_URI = "git://github.com/hyprwm/hyprpicker.git;protocol=https;branch=main"

PV = "0.3.0"
S = "${WORKDIR}/git"
SRCREV = "8791f717ef495c8c5a36b21cbccc7cf218fbc380"

DEPENDS = " \
	cairo \
	fribidi \
	jpeg \
	libxkbcommon \
	pango \
	pcre \
	util-linux \
	wayland \
	wayland-native \
	wayland-protocols \
"

RDEPENDS:${PN} = "wl-clipboard"

REQUIRED_DISTRO_FEATURES = "wayland"

EXTRA_OEMAKE = "-DCMAKE_BUILD_TYPE:STRING=Release"

do_install() {
    install -d ${D}${bindir} ${D}${datadir}/man/man1
    install -m755 ${B}/hyprpicker ${D}${bindir}
    install -m644 ${S}/doc/hyprpicker.1 ${D}${datadir}/man/man1
}

inherit cmake pkgconfig features_check
