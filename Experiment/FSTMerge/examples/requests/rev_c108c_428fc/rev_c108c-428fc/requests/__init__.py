

"""
requests
~~~~~~~~

:copyright: (c) 2011 by Kenneth Reitz.
:license: ISC, see LICENSE for more details.

"""


__title__ = 'requests'

~~FSTMerge~~ __version__ = '0.7.3' ##FSTMerge## __version__ = '0.7.2' ##FSTMerge## __version__ = '0.8.0'

~~FSTMerge~~ __build__ = 0x000703 ##FSTMerge## __build__ = 0x000702 ##FSTMerge## __build__ = 0x000800

__author__ = 'Kenneth Reitz'

__license__ = 'ISC'

__copyright__ = 'Copyright 2011 Kenneth Reitz'



from . import utils



from .api import request, get, head, post, patch, put, delete

from .sessions import session

from .status_codes import codes

from .exceptions import (
    RequestException, AuthenticationError, Timeout, URLRequired,
    TooManyRedirects, HTTPError
)



from .models import Request, Response
