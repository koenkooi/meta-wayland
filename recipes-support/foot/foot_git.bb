SUMMARY = "A fast, lightweight and minimalistic Wayland terminal emulator."
HOMEPAGE = "https://codeberg.org/dnkl/foot"
BUGTRACKER = "https://codeberg.org/dnkl/foot/issues"
SECTION = "base/shell"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3a7351a597a91e763901f7c76f21e798"

DEPENDS = " \
	fcft \
	fontconfig \
	freetype \
	libxkbcommon \
	pixman \
	wayland \
	wayland-native \
"

RRECOMMENDS:${PN} = "ncurses-terminfo"

SRC_URI = " \
	git://codeberg.org/dnkl/foot.git;protocol=https;branch=master \
	file://0001-generate-version.sh-dont-try-to-fetch-version-from-g.patch \
"

S = "${WORKDIR}/git"
PV = "1.19.0"
SRCREV = "d523e7a676d6d2cdda0369fac3dc9f953d3a4e96"

PACKAGECONFIG[grapheme-clustering] = "-Dgrapheme-clustering=enabled,-Dgrapheme-clustering=disabled,utf8proc"
PACKAGECONFIG[docs] = "-Ddocs=enabled,-Ddocs=disabled,scdoc-native"
PACKAGECONFIG[themes] = "-Dthemes=true,-Dthemes=false"

PACKAGECONFIG ?= " \
	grapheme-clustering \
	themes \
"

EXTRA_OEMESON += "--buildtype=release -Dterminfo=disabled"

inherit meson pkgconfig

FILES:${PN} = " \
	${bindir} \
	${datadir} \
	${libdir} \
	${sysconfdir} \
"

BBCLASSEXTEND = ""

