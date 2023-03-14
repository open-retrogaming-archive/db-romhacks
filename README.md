# Database Of Romhacks

## Objective
This repository contains in a 'structured' way, both 'information' and 'patches' related with romhacks.

This is mainly an archival project, it CANNOT replace the original community sites.

It 'normalizes' the original patches distributions into a structure that is easier to process automatically to:
- Build romhacks collections given that the user has a copy of the original game rom.
- Generate DAT files to use in rom managers to validate collections.
- Provide BPS patches even when originaly where distributed using a different format.

## Directories
There is two main categories 'hacks' and 'translations'

```
System Name
    |- Game Name / Rom Name:
        |- hacks:
            |- Name: As indicated on metadata
                |- romhack.bps: Custom patch that ensures compatibilty with a well known rom
                |- romhack.xml: Metadata
                |- romhack-bundle: Originaly distributed files
                    |- ...
        |- translations:
            | - two-letter-iso-language-code: https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
                |- Name
                    |- romhack.bps
                    |- romhack.xml
                    |- romhack-bundle
                        |- ...
```

## Files
romhack.xml Example:
```
<romhack>
    <name>3x3 Eyes - Juuma Houkan (Japan) [T-En by Atomizer_Zero v1.01]</name>
    <patchtype>bps</patchtype>
    <baseCRC>ad4ad163</baseCRC>
    <patchCRC>2144df1c</patchCRC>
    <finalCRC>b455b7a4</finalCRC>
    <author>Atomizer_Zero</author>
    <url>https://www.romhacking.net/translations/2835/</url>
    <version>1.01</version>
    <releasedate>2017-02-02</releasedate>
    <status>Fully Playable</status>
</romhack>
```
- releasedate: SHOULD follow the pattern YYYY-MM-DD.
- status: One of the two 'Fully Playable' or 'Incomplete'.

## Optional Patches
Some romhacks contain a myriad of optional patches.
This project prefers to normalize such options under a few curated ones released as different romhacks under the same game.
When several romhacks come from the same 'romhack-bundle' a symlink SHOULD be used.

## Providing Changes to the repository
- 1 Commit -> 1 Romhack
- Commit Message -> Romhack name

## Current Goals
- Write tool to create roms from database
- Write tool to create dat from database
- Porting already curated hacks found at https://www.romhackdb.com/
- Porting already curated hacks found at https://archive.org/details/En-ROMs
- Porting already curated hacks found at https://archive.org/details/super-famicom-enhanced-colors
- Porting already curated hacks found at https://archive.org/details/sfc-speedhacks
- Porting already curated hacks found at https://archive.org/details/SegaMD-Enhanced-ROMs
- Long Term Goal: Porting hacks from comunity sites

## Tools

## Documentation
There is many patch formats, some only used by certain comunities to patch certain games, other more widely used.

Today IPS and BPS patch formats are considered De facto standards. Hence the focus on these.

|     |     |     |     |
| --- | --- | --- | --- |
| **Format** | **Creation Date** | **Author** | **Description** |
| [IPS](/doc/ips/ips.md) | >= 1993   | Unknown | Original patch format, used to this day. Mainly when input validation is better avoided. |
| [UPS](/doc/ups1/ups-spec.pdf) | 2008   | Near | Designed to replace IPS. Provides validation for input and output. |
| [BPS](/doc/bps1/bps_spec.md) | 2012   | Near | Designed to replace IPS. Provides validation for input, output and patch. |

## Why a Git repository?
Initially it seems like a misuse of Git since the bulk of the repository is going to be binary data coming from patches.

Git is replacing:
- A website used to share content.
- An application used to submit content.

In this case Git provides instantly the infrastructure needed to bootstrap the project.

Most romhacks:
- Come from the first four console generations.
- Are created from very small patch files.

It is to acknoledge that to handle romhacks from fifth console generation onwards some extensions will be needed.